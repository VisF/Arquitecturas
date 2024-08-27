package main;

import DAO.DAOFactory;
//import Modelo.Cliente;
import conection.ConnectionFactory;

public class Main {

	public static void main(String[] args) {
		DAOFactory dao_factory = DAOFactory.getInstance();
		dao_factory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
		//dao_factory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
	}

}
