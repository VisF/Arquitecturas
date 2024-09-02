package main;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import CSVHandler.ClienteCSVHandler;
import CSVHandler.FacturaCSVHandler;
import CSVHandler.ProductoCSVHandler;
import DAO.DAOFactory;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;
//import Modelo.Cliente;
import conection.ConnectionFactory;


public class Main {

	public static void main(String[] args) {
		DAOFactory dao_factory = DAOFactory.getInstance();
		//dao_factory.getFacturaDAO(ConnectionFactory.DERBY).crear_tabla();
		//dao_factory.getProductoDAO(ConnectionFactory.DERBY).crear_tabla();
		/*
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
		
		
		
		/*  ---  CSV  ---  */
		/*
		ProductoCSVHandler csv = new ProductoCSVHandler();
		csv.procesarCSV("./src/csvfiles/datasets/productos.csv");
		*/ 
		
		/*
		ClienteCSVHandler csvCliente = new ClienteCSVHandler();
		csvCliente.procesarCSV("./src/csvfiles/datasets/clientes.csv");
		//agrega los mails con " al final
		 */
		FacturaCSVHandler csvFactura = new FacturaCSVHandler();
		csvFactura.procesarCSV("./src/csvfiles/datasets/facturas.csv");
		

		/*
		List<Producto> productos = new ArrayList<>();
		productos = dao_factory.getProductoDAO(ConnectionFactory.DERBY).listar();
		
		for(int i=0;i<productos.size();i++) {
			System.out.println("Id Producto: " + productos.get(i).getIdProducto() + " nombre del producto: " + productos.get(i).getNombre() + " valor: " + productos.get(i).getValor());
			
		}
		*/
		
		
		
		/*  --- MySQL --- */
		
		/*
		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNombre("PrimeraPrueba");
		cliente1.setEmail("facundo");
		
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).insertar(cliente1);
		//cliente1.setId(2);
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).actualizar(cliente1);
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).eliminar(cliente1);
		 */
	
		/*
		List<Cliente> clientes = new ArrayList<>();
		clientes = dao_factory.getClienteDAO(ConnectionFactory.MYSQL).listar();
		
		/*for(Cliente cl :clientes) {
		      System.out.println(cl.toString());
		    }
		   */
		/*
		 for (int i=0;i<clientes.size();i++) {
		      
		      System.out.println(clientes.get(i).toString());
		    }
		 */
		
		
		
		
		/*  ---  EJERCICIO 3  ---  */
		/*
		Producto masRecaudador = dao_factory.getProductoDAO(ConnectionFactory.MYSQL).getMasRecaudador();
		System.out.println(masRecaudador.toString());
		*/
	
		
	}

}
