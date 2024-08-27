package DAO;

import java.util.List;
import Modelo.Cliente;

public interface ClienteDAO {
	public void crear_tabla(); //sacar?

	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public void eliminar(Cliente cliente);
	
	//public Cliente buscar_por_nombre(String nombre);
	
	public List<Cliente> listar();
	
	public List<Cliente> listarOrdenadoPorFacturacion();
}
