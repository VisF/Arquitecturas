package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
import Modelo.Factura;
import conection.ConnectionFactory;

public class ClienteDAOImpDerby implements ClienteDAO{
	private Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
	@Override
	
	//TODO singleton
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
		try {
	        String sql = "INSERT INTO CLIENTE (id, nombre, email) VALUES (?,?,?)";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, cliente.getId());
	        stmt.setString(2, cliente.getNombre());
	        stmt.setString(3, cliente.getEmail());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		try {
	        String sql = "UPDATE Cliente SET nombre = ?, email = ? WHERE id = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        
	        stmt.setString(1, cliente.getNombre());
	        stmt.setString(2, cliente.getEmail());
	        stmt.setInt(3, cliente.getId());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void eliminar(Cliente cliente) {
		try {
	        String sql = "DELETE FROM Cliente WHERE id = ?";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);
	        stmt.setInt(1, cliente.getId());
	        stmt.executeUpdate();
	        //stmt.close();
	        ConnectionFactory.getInstance().disconnect();
	    } catch (SQLException e) {
	    	System.err.println("Error al insertar la factura: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Cliente";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	Cliente cliente = new Cliente();
	        	cliente.setId(rs.getInt("id"));
	        	cliente.setNombre(rs.getString("nombre"));
	        	clientes.add(cliente);
	        }

		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public List<Cliente> listarOrdenadoPorFacturacion() {
		
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "SELECT c.*"
					+ "	FROM cliente c INNER JOIN factura f On c.id = f.idCliente"
					+ "	INNER JOIN factura_producto fp ON f.idFactura = fp.idFactura"
					+ "	INNER JOIN producto p ON fp.idProducto = p.idProducto"
					+ "	GROUP BY c.id"
					+ "	ORDER BY SUM(fp.cantidad * p.valor) DESC";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	Cliente cliente = new Cliente();
	        	cliente.setId(rs.getInt("id"));
	        	cliente.setNombre(rs.getString("nombre"));
	        	clientes.add(cliente);
	        }

		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return clientes;
	}

	
}
