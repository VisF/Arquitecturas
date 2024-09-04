package CSVHandler;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import DAO.DAOFactory;
import Modelo.FacturaProducto;
import conection.ConnectionFactory;

public class FacturaProductoCSVHandler {
	private String basededatos;
	public FacturaProductoCSVHandler(String bbdd) {
		this.basededatos = bbdd;
	}
	public void procesarCSV(String archivoCSV) {
       List<FacturaProducto> facturaProductos = new ArrayList<>();
       
       try (@SuppressWarnings("deprecation")
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {  //CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {
           for (CSVRecord row : parser) {
        	   FacturaProducto facturaProducto = new FacturaProducto();
        	   facturaProducto.setIdFactura(Integer.parseInt(row.get("idFactura")));
        	   facturaProducto.setIdProducto(Integer.parseInt(row.get("idProducto")));
        	   facturaProducto.setCantidad(Integer.parseInt(row.get("cantidad")));
        	   facturaProductos.add(facturaProducto);
           }
       } catch (IOException e) {
           e.printStackTrace();
           System.err.println("Error al leer el archivo CSV: " + e.getMessage());
       }
       
       // Actualizar los productos en la base de datos
       for(FacturaProducto facturaProducto : facturaProductos){
       	
       	DAOFactory dao_factory = DAOFactory.getInstance();
       	dao_factory.getFacturaProductoDAO(basededatos).insertar(facturaProducto);
       	
       	//System.out.println(facturaProducto.getIdFactura() + ";" + facturaProducto.getIdProducto() + ";" + facturaProducto.getCantidad());
       	
       }
   }
}
