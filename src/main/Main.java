package main;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import CSVHandler.ClienteCSVHandler;
import CSVHandler.FacturaCSVHandler;
import CSVHandler.FacturaProductoCSVHandler;
import CSVHandler.ProductoCSVHandler;
import DAO.DAOFactory;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.FacturaProducto;
import Modelo.Producto;
//import Modelo.Cliente;
import conection.ConnectionFactory;


public class Main {

	public static void main(String[] args) {
		DAOFactory dao_factory = DAOFactory.getInstance();
		String ddbb = ConnectionFactory.MYSQL;
		String ddbb2 = ConnectionFactory.DERBY;
		//crearTablas(dao_factory,ddbb2);
		
		//insertarTuplas(ddbb2);
		
		//System.out.println(dao_factory.getProductoDAO(ddbb).getMasRecaudador());
		//System.out.println(dao_factory.getClienteDAO(ddbb).listarOrdenadoPorFacturacion());
		
		System.out.println(dao_factory.getProductoDAO(ddbb2).getMasRecaudador());
		
		List<Cliente> clientesOrdenadosFacturacion = dao_factory.getClienteDAO(ddbb2).listarOrdenadoPorFacturacion();
		for(Cliente cliente : clientesOrdenadosFacturacion) {
			System.out.println(cliente);
		}
		/*
		
		List<Cliente> clientes = dao_factory.getClienteDAO(ddbb).listar();
		for(Cliente cliente: clientes) {
			System.out.println(cliente.toString());
		}

		List<Factura> facturas = dao_factory.getFacturaDAO(ddbb).listar();
		
		for(Factura factura: facturas) {
			System.out.println(factura.toString());
		}

		List<Producto> productos = new ArrayList<>();
		productos = dao_factory.getProductoDAO(ddbb).listar();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
		
		List<FacturaProducto> fp = new ArrayList<>();
		fp = dao_factory.getFacturaProductoDAO(ddbb).listar();
		
		for(FacturaProducto facturaProducto: fp) {
			System.out.println(facturaProducto);
		}
		*/
		
	}

	private static void insertarTuplas(String bbdd) {
		ClienteCSVHandler csvCliente = new ClienteCSVHandler(bbdd);
		csvCliente.procesarCSV("./src/csvfiles/datasets/clientes.csv");
		
		ProductoCSVHandler csv = new ProductoCSVHandler(bbdd);
		csv.procesarCSV("src/CSVFiles/datasets/productos.csv");
		
		FacturaCSVHandler csvFactura = new FacturaCSVHandler(bbdd);
		csvFactura.procesarCSV("./src/csvfiles/datasets/facturas.csv");
		
		FacturaProductoCSVHandler csvFacturaProducto = new FacturaProductoCSVHandler(bbdd);
		csvFacturaProducto.procesarCSV("./src/csvfiles/datasets/facturas-productos.csv");
	}

	private static void crearTablas (DAOFactory dao_factory, String ddbb) {
		dao_factory.getClienteDAO(ddbb).crear_tabla();
		dao_factory.getProductoDAO(ddbb).crear_tabla();
		dao_factory.getFacturaDAO(ddbb).crear_tabla();
		dao_factory.getFacturaProductoDAO(ddbb).crear_tabla();
	}

}
