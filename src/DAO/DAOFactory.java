package DAO;

import conection.ConnectionFactory;

public class DAOFactory {
	
	private static DAOFactory instance = new DAOFactory();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public ClienteDAO getClienteDAO(String type) {
		if (type.equals(ConnectionFactory.MYSQL)) {
			return new ClienteDAOImpMySQL();
		}
		if (type.equals(ConnectionFactory.DERBY)) {
			return new ClienteDAOImpDerby();
		}

		throw new IllegalArgumentException("Tipo de DAO no v�lido: " + type);

	}
	
	public FacturaDAO getFacturaDAO(String type) {
		if (type.equals(ConnectionFactory.MYSQL)) {
			return new FacturaDAOImpMySQL();
		}
		if (type.equals(ConnectionFactory.DERBY)) {
			return new FacturaDAOImpDerby();
		}

		throw new IllegalArgumentException("Tipo de DAO no v�lido: " + type);

	}
	
	public ProductoDAO getProductoDAO(String type) {
		if (type.equals(ConnectionFactory.MYSQL)) {
			return new ProductoDAOImpMySQL();
		}
		if (type.equals(ConnectionFactory.DERBY)) {
			return new ProductoDAOImpDerby();
		}

		throw new IllegalArgumentException("Tipo de DAO no v�lido: " + type);

	}
	
	public FacturaProductoDAO getFacturaProductoDAO(String type) {
		if (type.equals(ConnectionFactory.MYSQL)) {
			return new FacturaProductoDAOimpMySQL();
		}
		if (type.equals(ConnectionFactory.DERBY)) {
			return new FacturaProductoDAOImpDerby();
		}

		throw new IllegalArgumentException("Tipo de DAO no v�lido: " + type);

	}

}
