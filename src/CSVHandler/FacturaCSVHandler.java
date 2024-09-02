package CSVHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOFactory;
import Modelo.Factura;
import conection.ConnectionFactory;


public class FacturaCSVHandler {
		
		public FacturaCSVHandler() {
	    }
	    
		
	    public void procesarCSV(String archivoCSV) {
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
	        	dao_factory.getFacturaDAO(ConnectionFactory.MYSQL).insertar(factura);
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


