package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Producto;
import conection.ConnectionFactory;

public class ProductoDAOImpMySQL  implements ProductoDAO{

	private Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
	
	@Override
	public void crear_tabla() {
		try {
			//this.connection.getInstance().
			Statement stmt = this.connection.createStatement();
			String sql = "CREATE TABLE Producto (idProducto INT, nombre VARCHAR(45),valor FLOAT, PRIMARY KEY (idProducto))";
			stmt.executeUpdate(sql);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
