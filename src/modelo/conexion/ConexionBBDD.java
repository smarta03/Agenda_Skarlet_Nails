package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexion con la base de datos
 * Sige el patr�n Singleton
 * @author Laural
 */
public class ConexionBBDD {
	
	private static ConexionBBDD instanciaConexion;

	private String dataBaseURL;
	private String userName;
	private String password;
	private String serverName;
	private String driverName;
	private Connection conexion;
	
	public ConexionBBDD(){
		this.dataBaseURL = "jdbc:mysql://localhost:3306/ag_sn?autoReconnect=true&useSSL=true";
		this.userName = "root";
		this.password = "1234";
		this.serverName = "localhost";
		this.driverName = "com.mysql.cj.jdbc.Driver";
	}
	
    public static ConexionBBDD getInstance() {
   	 if (instanciaConexion == null) {
   		instanciaConexion = new ConexionBBDD();
   	 }
   	 return instanciaConexion;
   }
	
	public void setDataBaseURL(String dataBaseURL) {
		this.dataBaseURL = dataBaseURL;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	 
	 /**
	  * Crea una nueva conexi�n con la base de datos (objeto conexion de tipo Connection) para poder
	  * realizar operaciones con ella.
	 * @throws ClassNotFoundException 
	  * 
	  * @throws Exception Si ha ocurrido alg�n error para establecer la conexi�n con la base de datos.
	  * 				  Si se ha abierto al base de datos estando ya abierta la conexion.
	  */
	public void abrirConexion() throws SQLException, ClassNotFoundException {
		try{
			if(this.conexion != null) {
				if(!(this.conexion.isClosed())) { //Si la conexion esta abierta y se ha vuelto a abrir
					System.out.println("Conexion ya abierta");
					throw new SQLException("Se ha intentado abrir la conexion con la base de datos cuando ya estaba abierta");
				}
			}
			Class.forName(this.driverName);
			this.conexion = DriverManager.getConnection(this.dataBaseURL, this.userName, this.password);
			System.out.println ("Se ha abierto la conexion con la base de datos.");
			
		} catch (SQLException e) {
			throw new SQLException("Al abrir la base de datos " + e.getMessage());
		}
	}
	
	/**
	 * Cierra la conexi�n con la base de datos (objeto conexion de tipo Connection)
	 * 
	 * @throws Exception Si ha ocurrido alg�n error al cerrar la conexi�n con la base de datos.
	 * 					 Si se ha cerrado al conexion con la base de datos cuando estaba cerrada al conexion.
	 */
	public void cerrarConexion() throws SQLException {
		try {
			if(this.conexion.isClosed()) {
				System.out.println("Se ha intentado cerrar la conexion con la base de datos cuando ya estaba cerrada");
				throw new SQLException("Se ha intentado cerrar la conexion con la base de datos cuando ya estaba cerrada");
			}
			
			this.conexion.close();
			System.out.println ("Cierre correcto de la conexion con la base de datos");
		} catch (SQLException e) {
			throw new SQLException("Al cerrar la conexion de la base de datos. " + e.getMessage());
		}
	}
	
}