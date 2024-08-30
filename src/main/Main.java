package main;

import java.util.ArrayList;
import java.util.List;

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
		
		ProductoCSVHandler csv = new ProductoCSVHandler();
		//csv.procesarCSV("./src/csvfiles/datasets/producto2.csv");
		List<Producto> productos = new ArrayList<>();
		productos = dao_factory.getProductoDAO(ConnectionFactory.DERBY).listar();
		
		for(int i=0;i<productos.size();i++) {
			System.out.println("Id Producto: " + productos.get(i).getIdProducto() + "nombre del producto: " + productos.get(i).getNombre() + " valor: " + productos.get(i).getValor());
			
		}
		
		
		
		
		/*  --- MySQL --- */
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNombre("PrimeraPrueba");
		cliente1.setEmail("facundo");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNombre("carolina");
		cliente2.setEmail("caro@gmail.com");
		
		Cliente cliente3 = new Cliente();
		cliente3.setId(3);
		cliente3.setNombre("ramiro");
		cliente3.setEmail("ramiro@hotmail.com");
		
		/*dao_factory.getClienteDAO(ConnectionFactory.MYSQL).insertar(cliente1);
		dao_factory.getClienteDAO(ConnectionFactory.MYSQL).insertar(cliente2);
		dao_factory.getClienteDAO(ConnectionFactory.MYSQL).insertar(cliente3);
		
		*/
		//cliente1.setNombre("PruebaUpdate");
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).actualizar(cliente1);
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).eliminar(cliente1);
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
	}

}
