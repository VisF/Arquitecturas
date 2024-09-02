package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		try {
	        String sql = "INSERT INTO factura (idFactura, idCliente) VALUES (?,?)";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        
	        stmt.setInt(1, factura.getIdFactura());
	        stmt.setInt(2, factura.getIdCliente());
	        stmt.executeUpdate();
	        stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	        
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void actualizar(Factura factura) {
		try {
	        String sql = "UPDATE factura SET idCliente = ? WHERE idFactura = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        
	        stmt.setInt(1, factura.getIdCliente());
	        stmt.setInt(2, factura.getIdFactura());
	      
	        stmt.executeUpdate();
	        stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al actualizar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void eliminar(Factura factura) {
		try {
	        String sql = "DELETE FROM factura WHERE idFactura = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, factura.getIdFactura());
	        stmt.executeUpdate();
	        stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al eliminar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public List<Factura> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
