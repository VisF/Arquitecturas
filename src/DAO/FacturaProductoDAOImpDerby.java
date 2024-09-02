package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.FacturaProducto;
import conection.ConnectionFactory;

public class FacturaProductoDAOImpDerby implements FacturaProductoDAO{
	private Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
	@Override
	public void crear_tabla() {
		try {
			//this.connection.getInstance().
			Statement stmt = this.connection.createStatement();
			String sql = "CREATE TABLE factura_producto (idFactura INT, idProducto INT, cantidad INT, PRIMARY KEY (idFactura, idProducto), "
					+ "FOREIGN KEY (idFactura) REFERENCES Factura(idFactura), FOREIGN KEY (idProducto) REFERENCES Producto(idProducto))";
			stmt.executeUpdate(sql);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertar(FacturaProducto facturaProducto) {
		try {
	        String sql = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?,?,?)";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, facturaProducto.getIdFactura());
	        stmt.setInt(2, facturaProducto.getIdProducto());
	        stmt.setInt(3, facturaProducto.getCantidad());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public void actualizar(FacturaProducto facturaProducto) {
		try {
	        String sql = "UPDATE factura_producto SET cantidad = ? WHERE idFactura = ? AND idProducto = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, facturaProducto.getCantidad());
	        stmt.setInt(2, facturaProducto.getIdFactura());
	        stmt.setInt(3, facturaProducto.getIdProducto());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al actualizar la relacion: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void eliminar(FacturaProducto facturaProducto) {
		try {
	        String sql = "DELETE FROM factura_producto WHERE idFactura = ? AND idProducto = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(2, facturaProducto.getIdFactura());
	        stmt.setInt(3, facturaProducto.getIdProducto());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al borrar la relacion: " + e.getMessage());
	        e.printStackTrace();
	    }		
	}

}
