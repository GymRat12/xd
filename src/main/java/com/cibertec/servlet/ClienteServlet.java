package com.cibertec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibertec.business.ClienteService;
import com.cibertec.business.impl.ClienteServiceImpl;
import com.cibertec.constants.Constante;
import com.cibertec.model.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteService service = new ClienteServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {
		case Constante.REGISTRAR : 
			
			String nombre = request.getParameter("txtNombre");
			String apellidos = request.getParameter("txtApellidos");
			String dni = request.getParameter("txtDni");
			String direccion = request.getParameter("txtDireccion");
			
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setApellidos(apellidos);
			cliente.setDni(dni);
			cliente.setDireccion(direccion);
			
			int valor = service.guardarCliente(cliente);
			if(valor == 1) {
				listaClientes(request, response);
			} else {
				request.setAttribute("mensajeError", "Ocurrió un problema al registrar");
				request.getRequestDispatcher("listadoClientes.jsp").forward(request, response);
			}
			break;
		case Constante.ACTUALIZAR : 
			String nNombre = request.getParameter("txtNombre");
			String nApellidos = request.getParameter("txtApellidos");
			String nDni = request.getParameter("txtDni");
			String nDireccion = request.getParameter("txtDireccion");
			String nId = request.getParameter("txtId");
			
			Cliente nCliente = new Cliente();
			nCliente.setId(Integer.parseInt(nId));
			nCliente.setNombre(nNombre);
			nCliente.setApellidos(nApellidos);
			nCliente.setDni(nDni);
			nCliente.setDireccion(nDireccion);
			
			int valorActualizar = service.actualizarCliente(nCliente);
			if(valorActualizar == 1) {
				listaClientes(request, response);
			} else {
				request.setAttribute("mensajeError", "Ocurrió un problema al registrar");
				request.getRequestDispatcher("listadoClientes.jsp").forward(request, response);
			}
			break;
		case Constante.ELIMINAR : 
			int identificador = Integer.parseInt(request.getParameter("id"));
			int valorEliminar = service.eliminarCliente(identificador);
			if(valorEliminar == 1) {
				listaClientes(request, response);
			} else {
				request.setAttribute("mensajeError", "Ocurrió un problema al registrar");
				request.getRequestDispatcher("listadoClientes.jsp").forward(request, response);
			}
			break;
		case Constante.LISTAR : listaClientes(request, response); break;
		case Constante.DETALLE : 
			int id = Integer.parseInt(request.getParameter("id"));
			Cliente clienteDetalle = service.listarClientePorId(id);
			request.setAttribute("objeto", clienteDetalle);
			request.getRequestDispatcher("actualizaCliente.jsp").forward(request, response);
			break;
		default: listaClientes(request, response);
		}
		
	}
	
	private void listaClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> lista = service.listarClientes();
		request.setAttribute("data", lista);
		request.getRequestDispatcher("listadoClientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
