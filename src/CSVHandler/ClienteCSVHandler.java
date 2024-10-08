package CSVHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import DAO.DAOFactory;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;
import conection.ConnectionFactory;

public class ClienteCSVHandler {
	private String basededatos;
	
	public ClienteCSVHandler(String bbdd) {
		this.basededatos = bbdd;    }
	
	public void procesarCSV(String archivoCSV) {
        List<Cliente> clientes = new ArrayList<>();
        
        try (@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {  //CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {
            for (CSVRecord row : parser) {
            	Cliente cliente = new Cliente();
            	cliente.setId(Integer.parseInt(row.get("idCliente")));
            	cliente.setNombre(row.get("nombre"));
            	cliente.setEmail(row.get("email"));
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        
        // Actualizar los productos en la base de datos
        for(Cliente cliente : clientes){
        	
        	DAOFactory dao_factory = DAOFactory.getInstance();
        	dao_factory.getClienteDAO(basededatos).insertar(cliente);
        	
        	//System.out.println(cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getEmail());
        	
        }
    }
    /*
    public void procesarCSVviejo(String archivoCSV) {
        List<Cliente> clientes = new ArrayList<>();
        ArrayList<String[]> lines = this.readContent(archivoCSV);

		for (String[] line: lines) {
			String cleanedValue = line[0].trim().replace("\"", "");
			
			int idCliente = Integer.parseInt(cleanedValue);
			String nombre = line[1].trim();
			String email = line[2].trim();
			

			Cliente cliente = new Cliente();
			
			cliente.setId(idCliente);
			cliente.setNombre(nombre);
			cliente.setEmail(email);
			clientes.add(cliente);
			
			
		}
        for(Cliente cliente : clientes){
        	DAOFactory dao_factory = DAOFactory.getInstance();
        	dao_factory.getClienteDAO(basededatos).insertar(cliente);
        }
    }
    
    private ArrayList<String[]> readContent(String path) {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}*/
}
