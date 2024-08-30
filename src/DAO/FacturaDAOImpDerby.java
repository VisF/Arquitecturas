package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Factura;
import conection.ConnectionFactory;

public class FacturaDAOImpDerby implements FacturaDAO {
	private Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
	
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
	        String sql = "UPDATE Factura SET idCliente = ? WHERE idFactura = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        
	        stmt.setInt(1, factura.getIdCliente());
	        stmt.setInt(2, factura.getIdFactura());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
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
		List<Factura> facturas = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Factura";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Factura factura = new Factura();
	        	factura.setIdFactura(rs.getInt("idFactura"));
	        	factura.setIdCliente(rs.getInt("idCliente"));
	        	facturas.add(factura);
	        }

		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return facturas;
	}

}
