package CSVHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOFactory;
import Modelo.Cliente;
import Modelo.Producto;
import conection.ConnectionFactory;

public class ClienteCSVHandler {
	
	public ClienteCSVHandler() {
    }
    
    public void procesarCSV(String archivoCSV) {
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
        	dao_factory.getClienteDAO(ConnectionFactory.DERBY).insertar(cliente);
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
	}
}
