package com.cibertec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.config.Conectar;
import com.cibertec.dao.ClienteDao;
import com.cibertec.model.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	
	private Conectar conectar;
	
	public ClienteDaoImpl() {
		conectar = new Conectar();
	}

	@Override
	public int insertaCliente(Cliente cliente) {
		
		int valor = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = conectar.conectarMySQL();
			String sql = "INSERT INTO Cliente VALUES (null,?,?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getDireccion());
			valor = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return valor;
	}

	@Override
	public List<Cliente> listarClientes() {
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = conectar.conectarMySQL();
			String sql = "SELECT * from Cliente";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				lista.add(cliente);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public Cliente listaClientePorId(int id) {
		Cliente cliente = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = conectar.conectarMySQL();
			String sql = "SELECT * from Cliente where idCliente = ?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cliente;
	}

	@Override
	public int actualizaCliente(Cliente cliente) {
		int valor = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = conectar.conectarMySQL();
			String sql = "UPDATE Cliente SET nombre = ?, apellidos = ?, dni = ?, direccion = ? where idCliente = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getDireccion());
			ps.setInt(5, cliente.getId());
			valor = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return valor;
	}

	@Override
	public int eliminaCliente(int id) {
		int valor = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = conectar.conectarMySQL();
			String sql = "DELETE FROM Cliente where idCliente = ?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			valor = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return valor;
	}

}
