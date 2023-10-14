import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
    public static String[][] CrearEquipos() {
        String csvFile = "ejemplo.csv";
        BufferedReader br = null;
        String line = "";
        int i = 0;
        String[][] datos = new String[22][4];
        String[] datos2;
        // Se define separador ","
        String cvsSplitBy = ";";
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                datos2 = line.split(cvsSplitBy);
                for (int j = 0; j < datos2.length; j++) {
                    datos[i][j] = datos2[j];
                }
                i = i + 1;
            }

            return datos;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return datos;
    }
}
