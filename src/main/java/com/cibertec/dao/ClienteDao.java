package com.cibertec.dao;

import java.util.List;

import com.cibertec.model.Cliente;

public interface ClienteDao {

	public int insertaCliente(Cliente cliente);
	
	public List<Cliente> listarClientes();
	
	public Cliente listaClientePorId(int id);
	
	public int actualizaCliente(Cliente cliente);
	
	public int eliminaCliente(int id);	
	
}
