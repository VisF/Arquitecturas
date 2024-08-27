package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Factura;
import conection.ConnectionFactory;

public class FacturaDAOImpMySQL implements FacturaDAO{
private Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
	
	@Override
	public void crear_tabla() {
		try {
			//this.connection.getInstance().
			Statement stmt = this.connection.createStatement();
			String sql = "CREATE TABLE Factura (idFactura INT,idCliente INT, PRIMARY KEY (idFactura), FOREIGN KEY (idCliente) REFERENCES Cliente(id))";
			stmt.executeUpdate(sql);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Factura> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
