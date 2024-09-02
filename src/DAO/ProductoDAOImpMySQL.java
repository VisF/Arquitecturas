package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
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
		try {
	        String sql = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?,?,?)";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, producto.getIdProducto());
	        stmt.setString(2, producto.getNombre());
	        stmt.setFloat(3, producto.getValor());
	        stmt.executeUpdate();
	        stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar el producto: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void actualizar(Producto producto) {
		try {
	        String sql = "UPDATE producto SET nombre = ?, valor = ? WHERE idProducto = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        
	        stmt.setString(1, producto.getNombre());
	        stmt.setFloat(2, producto.getValor());
	        stmt.setInt(3, producto.getIdProducto());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al actualizar el cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void eliminar(Producto producto) {
		try {
	        String sql = "DELETE FROM producto WHERE idProducto = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, producto.getIdProducto());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al eliminar el producto: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Producto";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	Producto producto = new Producto();
	        	producto.setIdProducto(rs.getInt("idProducto"));
	        	producto.setNombre(rs.getString("nombre"));
	        	producto.setValor(rs.getFloat("valor"));
	        	productos.add(producto);
	        }

		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public Producto getMasRecaudador() {
		Producto masRecaudador = null;
		try {
			//TODO ni idea si funciona
			String sql = "SELECT * "
						+ "FROM producto "
						+ "WHERE producto.idProducto = (SELECT p.idProducto, MAX(SUM(fp.cantidad) * p.valor AS 'recaudacion') "
						+ 								"FROM Producto p LEFT JOIN factura_producto fp "
						+ 								"ON p.idProducto = fp.idProducto )";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
	        	masRecaudador = new Producto();
	        	masRecaudador.setIdProducto(rs.getInt("idProducto"));
	        	masRecaudador.setNombre(rs.getString("nombre"));
	        	masRecaudador.setValor(rs.getFloat("valor"));
	        }

		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return masRecaudador;
	}

}
