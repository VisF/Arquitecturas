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
import Modelo.Producto;
import conection.ConnectionFactory;


public class ProductoCSVHandler {
	
    
    public ProductoCSVHandler() {
    }
    
    public void procesarCSV(String archivoCSV) {
        List<Producto> productos = new ArrayList<>();
        ArrayList<String[]> lines = this.readContent(archivoCSV);

		for (String[] line: lines) {
			
			int idProducto = Integer.parseInt(line[0].trim());
			String nombre = line[1].trim();
			float valor = Float.parseFloat(line[2].trim());

			Producto producto = new Producto();
			
			producto.setIdProducto(idProducto);
			producto.setNombre(nombre);
			producto.setValor(valor);
			productos.add(producto);
			
		}
        for(Producto producto : productos){
        	DAOFactory dao_factory = DAOFactory.getInstance();
        	dao_factory.getProductoDAO(ConnectionFactory.DERBY).insertar(producto);
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
