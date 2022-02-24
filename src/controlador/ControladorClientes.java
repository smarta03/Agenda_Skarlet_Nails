package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.ClientesDao;
import modelo.vo.ClienteVo;

public class ControladorClientes {
	private ClientesDao cliDao;
	
	public ControladorClientes() {
		cliDao = new ClientesDao();
	}
	
	public List<ClienteVo> recogerLista() throws Exception {
		return cliDao.recogerLista();
	}
	
	public ClienteVo devolverUsuario(String nombre, String primer_apellido, String segundo_apellido) throws SQLException {
		return cliDao.devolverUsuario(nombre, primer_apellido, segundo_apellido);
	}

	public void registrarNuevoCliente(String nom, String p_apellido, String s_apellido, String pseudo, String f_nac, String numTelefono, String correo, String lo) throws Exception {
		cliDao.insertar(new ClienteVo(nom, p_apellido, s_apellido, pseudo, f_nac, numTelefono, correo, lo)); 
	}
	
}
