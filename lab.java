
import java.util.*;
import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

class Jugador {
    String nombre;
    ArrayList<Jugador> adyacente;
    int velocidad, posesion, remate;

    public Jugador(String nombre, int velocidad, int posesion, int remate) {
        this.adyacente = new ArrayList<>();
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.remate = remate;
        this.posesion = posesion;
    }

    public void agregarAdyacente(Jugador v) {
        this.adyacente.add(v);
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getPosesion() {
        return posesion;
    }

    public int getRemate() {
        return remate;
    }

    public void setMatrizAdyacencia(int[] matrizAdyacencia) {
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            if (matrizAdyacencia[i] == 1) {
                this.agregarAdyacente(new Jugador("Jugador" + (i + 1), 0, 0, 0));
            }
        }
    }

    public String toString() {
        return "Jugador{"
                + "nombre='" + nombre + '\''
                + ", adyacentes="
                + adyacente.stream().map(Jugador::getNombre).collect(Collectors.joining(", ")) +
                '}';
    }
}

class Campo {
    private List<Jugador> jugadores;
    private int[][] matrizAdyacencia;

    public Campo() {
        jugadores = new ArrayList<>();
        // Define la matriz de adyacencia según tus necesidades
        matrizAdyacencia = new int[][] {
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
        };

        for (int i = 0; i < 11; i++) {
            jugadores.add(new Jugador("Jugador" + (i + 1), 0, 0, 0));
        }

        // Asigna la matriz de adyacencia a cada jugador
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setMatrizAdyacencia(matrizAdyacencia[i]);
        }
    }

    public List<Jugador> calcularCaminoOptimo(Jugador inicio, Jugador fin, String estrategia) {
        // ... (La función calcularCaminoOptimo que se mostró en respuestas anteriores)
    }

    public Jugador getJugadorPorNombre(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }
}

class Archivo {
    public static String[][] CrearEquipos() {
        String csvFile = "ejemplo.csv";
        BufferedReader br = null;
        String line = "";
        int i = 0;
        String[][] datos = new String[22][4];
        String[] datos2;
        String cvsSplitBy = ";";
        
        try {
            br = new BufferedReader(new FileReader(csvFile);

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

public class Main {
    public static void main(String[] args) {
        int contador = 0;
        String[][] jugadores = Archivo.CrearEquipos();
        Jugador[] equipo = new Jugador[11]; // 11 jugadores

        for (int i = 0; i < 11; i++) {
            equipo[i] = new Jugador(jugadores[i][0], Integer.parseInt(jugadores[i][1]),
                    Integer.parseInt(jugadores[i][2]), Integer.parseInt(jugadores[i][3]));
        }

        // Crear una instancia de Campo y asignar el arreglo de jugadores
        Campo campo = new Campo();
        campo.setJugadores(Arrays.asList(equipo));

        // Obtener los jugadores de inicio y fin
        Jugador jugadorInicio = campo.getJugadorPorNombre("Jugador1");
        Jugador jugadorFin = campo.getJugadorPorNombre("Jugador11");

        // Calcular el camino óptimo con una estrategia (puedes cambiarla)
        String estrategia = "velocidad"; // Puedes cambiar la estrategia
        List<Jugador> caminoOptimo = campo.calcularCaminoOptimo(jugadorInicio, jugadorFin, estrategia);

        // Imprimir el camino óptimo
        System.out.println("Camino óptimo (" + estrategia + "):");
        for (Jugador jugador : caminoOptimo) {
            System.out.println(jugador.getNombre());
        }
    }
}
