package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.conexion.ConexionBBDD;
import modelo.dao.ClientesDao;
import modelo.vo.ClienteVo;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ConexionBBDD con = new ConexionBBDD();
		try {
			con.abrirConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*ClienteVo cli = new ClienteVo("Nombre", "priApe", "segApe", "pse", "fec_nac", "tel","correo","Y");
		ClientesDao cd = new ClientesDao();
		cli.setId_cliente(9);
		//cd.insertar(cli);
		//cd.eliminar(cli);
		
		ArrayList<ClienteVo> lista = (ArrayList<ClienteVo>) cd.recogerLista();
		cd.eliminar(lista.get(lista.size()-1));
		System.out.println();*/
		
		ControladorClientes cc = new ControladorClientes();
		//cc.registrarNuevoCliente("Nombre", "priApe", "segApe", "pse", "fec_nac", "tel","correo","Y");
		
		ClienteVo cliente = cc.devolverUsuario("Nombre", "priApe2", "segApe");
		System.out.println();
		
	}

}
