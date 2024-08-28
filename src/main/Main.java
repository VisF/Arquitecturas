package main;

import java.util.ArrayList;
import java.util.List;

import DAO.DAOFactory;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;
//import Modelo.Cliente;
import conection.ConnectionFactory;
import CSVFiles.ProductoCSVHandler;


public class Main {

	public static void main(String[] args) {
		DAOFactory dao_factory = DAOFactory.getInstance();
		//dao_factory.getFacturaDAO(ConnectionFactory.DERBY).crear_tabla();
		/*//dao_factory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNombre("PrimeraPrueba");
		cliente1.setEmail("facundo");
		//dao_factory.getClienteDAO(ConnectionFactory.DERBY).insertar(cliente1);
		
		
		Factura factura = new Factura();
		factura.setIdCliente(1);
		factura.setIdFactura(1);
		System.out.println(factura.getIdCliente());
	//	dao_factory.getFacturaDAO(ConnectionFactory.DERBY).insertar(factura);
		List<Factura> facturas = new ArrayList<>();
		facturas = dao_factory.getFacturaDAO(ConnectionFactory.DERBY).listar();
		*/
		
		ProductoCSVHandler csv = new ProductoCSVHandler();
		csv.procesarCSV("/CSVFiles/productos.csv");
		List<Producto> productos = new ArrayList<>();
		productos = dao_factory.getProductoDAO(ConnectionFactory.DERBY).listar();
		
		for(int i=0;i<10;i++) {
			System.out.println("Factura " + productos.get(i).getIdProducto() + " con cliente " + productos.get(i).getNombre());
		}
	}

}
