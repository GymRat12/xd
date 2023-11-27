package com.cibertec.business;

import java.util.List;

import com.cibertec.model.Cliente;

public interface ClienteService {

	public int guardarCliente(Cliente cliente);
	
	public int actualizarCliente(Cliente cliente);
	
	public List<Cliente> listarClientes();
	
	public Cliente listarClientePorId(int id);
	
	public int eliminarCliente(int id);
}
