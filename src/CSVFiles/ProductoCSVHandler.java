package CSVFiles;
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
        
        try (CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {
            for (CSVRecord row : parser) {
                Producto producto = new Producto();
                producto.setIdProducto(Integer.parseInt(row.get("idProducto")));
                producto.setNombre(row.get("nombre"));
                producto.setValor(Float.parseFloat(row.get("valor")));
                productos.add(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        
        // Actualizar los productos en la base de datos
        for(Producto producto : productos){
        	DAOFactory dao_factory = DAOFactory.getInstance();
        	dao_factory.getProductoDAO(ConnectionFactory.DERBY).insertar(producto);
        }
    }
    
   
}
