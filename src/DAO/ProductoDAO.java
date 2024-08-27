package DAO;

import java.util.List;

import Modelo.Producto;

public interface ProductoDAO {
	public void crear_tabla(); //sacar?

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(Producto producto);
	
	//public Cliente buscar_por_nombre(String nombre);
	
	public List<Producto> listar();
}
