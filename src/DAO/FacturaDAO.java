package DAO;

import java.util.List;
import Modelo.Factura;

public interface FacturaDAO {
	public void crear_tabla(); //sacar?

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Factura factura);
	
	//public Cliente buscar_por_nombre(String nombre);
	
	public List<Factura> listar();
}
