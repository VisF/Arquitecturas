package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Cliente;
import conection.ConnectionFactory;

public class ClienteDAOImpMySQL implements ClienteDAO{
	
	private Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
	
	@Override
	public void crear_tabla() {
		try {
			//this.connection.getInstance().
			Statement stmt = this.connection.createStatement();
			String sql = "CREATE TABLE Cliente (id INT, nombre VARCHAR(500),email VARCHAR(150), PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarOrdenadoPorFacturacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
