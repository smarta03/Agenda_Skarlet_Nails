package modelo.vo;

public class ClienteVo {

	private Integer id_cliente;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String pseudonimo;
	private String fecha_nacimiento;
	private String telefono;
	private String correo;
	private String lopd;
	
	public ClienteVo(int id_cli, String nom, String p_apellido, String s_apellido, String pseudo, String f_nac, String numTelefono, String correo, String lo) {
		
		this.id_cliente = id_cli;
		this.nombre = nom;
		this.primer_apellido = p_apellido;
		this.segundo_apellido = s_apellido;
		this.pseudonimo = pseudo;
		this.fecha_nacimiento = f_nac;
		this.telefono = numTelefono;
		this.correo = correo;
		this.lopd = lo;
	}
	
	public ClienteVo(String nom, String p_apellido, String s_apellido, String pseudo, String f_nac, String numTelefono, String correo, String lo) {
		
		this.nombre = nom;
		this.primer_apellido = p_apellido;
		this.segundo_apellido = s_apellido;
		this.pseudonimo = pseudo;
		this.fecha_nacimiento = f_nac;
		this.telefono = numTelefono;
		this.correo = correo;
		this.lopd = lo;
		
	}
	
	public ClienteVo() {
	}

	
	/**
	 * @return the id_cliente
	 */
	public Integer getId_cliente() {
		return id_cliente;
	}

	/**
	 * @param id_cliente the id_cliente to set
	 */
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the primer_apellido
	 */
	public String getPrimer_apellido() {
		return primer_apellido;
	}

	/**
	 * @param primer_apellido the primer_apellido to set
	 */
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	/**
	 * @return the segundo_apellido
	 */
	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	/**
	 * @param segundo_apellido the segundo_apellido to set
	 */
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	/**
	 * @return the pseudonimo
	 */
	public String getPseudonimo() {
		return pseudonimo;
	}

	/**
	 * @param pseudonimo the pseudonimo to set
	 */
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	/**
	 * @return the fecha_nacimiento
	 */
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	/**
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the lopd
	 */
	public String getLopd() {
		return lopd;
	}

	/**
	 * @param lopd the lopd to set
	 */
	public void setLopd(String lopd) {
		this.lopd = lopd;
	}

	
}
