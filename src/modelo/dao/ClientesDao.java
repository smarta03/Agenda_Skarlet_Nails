package modelo.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


import modelo.conexion.ConexionBBDD;
import modelo.vo.ClienteVo;

public class ClientesDao implements InterfazDao<ClienteVo>{
	
	public ClientesDao() {
		
	}
	
	@Override
	public List<ClienteVo> recogerLista() throws Exception {
		List<ClienteVo> listaClientes = new ArrayList<ClienteVo>();
		ConexionBBDD con = ConexionBBDD.getInstance();
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			con.abrirConexion();
			p = con.getConexion().prepareStatement("select * from clientes");
			rs = p.executeQuery();
			
			while(rs.next()) {
				ClienteVo cliente = new ClienteVo();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setPrimer_apellido(rs.getString("primer_apellido"));
				cliente.setSegundo_apellido(rs.getString("segundo_apellido"));
				cliente.setPseudonimo(rs.getString("pseudonimo"));
				cliente.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setCorreo(rs.getString("correo"));
				cliente.setLopd(rs.getString("lopd"));
				
				
				listaClientes.add(cliente);
				
			}
			
		} catch (Exception e) {
			throw new SQLException("Listar usuarios " + e.getMessage());
		}
		finally {
			try {
				con.cerrarConexion();
			} catch (Exception e) {
				throw new SQLException("Listar usuarios " + e.getMessage());
			}
		}
		return listaClientes;
	}

	@Override
	public void insertar(ClienteVo t) throws Exception{
		ConexionBBDD con = ConexionBBDD.getInstance();
		try {
			con.abrirConexion();
			PreparedStatement p = con.getConexion().prepareStatement("INSERT INTO clientes (id_cliente, nombre, primer_apellido, segundo_apellido, pseudonimo, fecha_nacimiento, telefono, correo, lopd) VALUES (?,?,?,?,?,?,?,?,?)");
			p.setNull(1, Types.INTEGER);
			p.setString(2, t.getNombre());
			p.setString(3, t.getPrimer_apellido());
			p.setString(4, t.getSegundo_apellido());
			p.setString(5, t.getPseudonimo());
			p.setString(6, t.getFecha_nacimiento());
			p.setString(7, t.getTelefono());
			p.setString(8, t.getCorreo());
			p.setString(9, t.getLopd());
			
			p.executeUpdate();
			
		} catch (Exception e) {
			throw new SQLException("Insertar cliente " + e.getMessage());
		}
		finally {
			try {
				con.cerrarConexion();
			} catch (Exception e) {
				throw new SQLException("Insertar cliente " + e.getMessage());
			}
		}
	}

	@Override
	public void eliminar(ClienteVo t) throws SQLException {
		ConexionBBDD con = ConexionBBDD.getInstance();
		PreparedStatement p = null;
		try {
			con.abrirConexion();
			p = con.getConexion().prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
			p.setInt(1, t.getId_cliente());
			p.execute();
		} catch(Exception e) {
			throw new SQLException("Insertar cliente " + e.getMessage());
		}
		finally {
			try {
				con.cerrarConexion();
			} catch (Exception e) {
				throw new SQLException("Insertar cliente " + e.getMessage());
			}
		}
	}

	/**
	 * Devuelve un cliente que tenga un nombre de usuario y una contraseña iguales a las pasadas por parámetros si lo encuentra en la
	 * base de datos
	 * @param nombreUsuario
	 * @param contraseña
	 * @return
	 * @throws SQLException 
	 */
	public ClienteVo devolverUsuario(String nom, String pri_ape, String seg_ape) throws SQLException {
		ClienteVo cliente = null;
		ConexionBBDD con = ConexionBBDD.getInstance();
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			con.abrirConexion();
			p = con.getConexion().prepareStatement("SELECT * FROM clientes WHERE nombre = ? AND primer_apellido = ? AND segundo_apellido = ?");
			p.setString(1, nom);
			p.setString(2, pri_ape);
			p.setString(3, seg_ape);
			rs = p.executeQuery();
			
			if(rs.next()) {
				cliente = new ClienteVo();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setPrimer_apellido(rs.getString("primer_apellido"));
				cliente.setSegundo_apellido(rs.getString("segundo_apellido"));
				cliente.setPseudonimo(rs.getString("pseudonimo"));
				cliente.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setCorreo(rs.getString("correo"));
				cliente.setLopd(rs.getString("lopd"));
			}
			
			return cliente;
			
		} catch (Exception e) {
			throw new SQLException("Devolver Usuario " + e.getMessage());
		}
		finally {
			try {
				con.cerrarConexion();
			} catch (Exception e) {
				throw new SQLException("Devolver Usuario " + e.getMessage());
			}
		}
	}

	
}
