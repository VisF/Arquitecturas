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
import Modelo.Factura;
import Modelo.Producto;
import conection.ConnectionFactory;


public class FacturaCSVHandler {
		private String basededatos;
		public FacturaCSVHandler(String bbdd) {
	    this.basededatos = bbdd;
		}
	    
		public void procesarCSV(String archivoCSV) {
	        List<Factura> facturas = new ArrayList<>();
	        
	        try (@SuppressWarnings("deprecation")
			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {  //CSVFormat.DEFAULT.withHeader().parse(new FileReader(archivoCSV))) {
	            for (CSVRecord row : parser) {
	                Factura factura = new Factura();
	                factura.setIdCliente(Integer.parseInt(row.get("idCliente")));
	                factura.setIdFactura(Integer.parseInt(row.get("idFactura")));
	                facturas.add(factura);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
	        }
	        
	        // Actualizar los productos en la base de datos
	        for(Factura factura : facturas){
	        	
	        	DAOFactory dao_factory = DAOFactory.getInstance();
	        	dao_factory.getFacturaDAO(basededatos).insertar(factura);
	        	
	        	//System.out.println(factura.getIdCliente() + ";" + factura.getIdFactura());
	        	
	        }
	    }
		/*
	    public void procesarCSVviejo(String archivoCSV) {
	        List<Factura> facturas = new ArrayList<>();
	        ArrayList<String[]> lines = this.readContent(archivoCSV);

			for (String[] line: lines) {
				String cleanedValue = line[0].trim().replace("\"", "");
				
				int idFactura = Integer.parseInt(cleanedValue);
				String cleanedValue2 = line[1].trim().replace("\"", "");
				int idCliente = Integer.parseInt(cleanedValue2);
				
				

				Factura factura = new Factura();
				
				factura.setIdFactura(idFactura);
				factura.setIdCliente(idCliente);
				facturas.add(factura);
				
				
			}
	        for(Factura factura : facturas){
	        	DAOFactory dao_factory = DAOFactory.getInstance();
	        	dao_factory.getFacturaDAO(basededatos).insertar(factura);
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


