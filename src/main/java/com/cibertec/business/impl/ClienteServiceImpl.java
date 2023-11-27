package com.cibertec.business.impl;

import java.util.List;

import com.cibertec.business.ClienteService;
import com.cibertec.dao.ClienteDao;
import com.cibertec.dao.impl.ClienteDaoImpl;
import com.cibertec.model.Cliente;

public class ClienteServiceImpl implements ClienteService {
	
	private ClienteDao dao = new ClienteDaoImpl();

	@Override
	public int guardarCliente(Cliente cliente) {
		return dao.insertaCliente(cliente);
	}

	@Override
	public int actualizarCliente(Cliente cliente) {
		return dao.actualizaCliente(cliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		return dao.listarClientes();
	}

	@Override
	public Cliente listarClientePorId(int id) {
		return dao.listaClientePorId(id);
	}

	@Override
	public int eliminarCliente(int id) {
		return dao.eliminaCliente(id);
	}

}
