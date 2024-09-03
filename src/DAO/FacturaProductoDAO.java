package DAO;

import java.util.List;

import Modelo.FacturaProducto;

public interface FacturaProductoDAO {

		public void crear_tabla(); //sacar?

		public void insertar(FacturaProducto facturaProducto);

		public void actualizar(FacturaProducto facturaProducto);

		public void eliminar(FacturaProducto facturaProducto);
		
		//public Cliente buscar_por_nombre(String nombre);
		
		public List<FacturaProducto> listar();
		
		//public List<FacturaProducto> listarOrdenadoPorFacturacion();
	}
