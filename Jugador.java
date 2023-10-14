import java.util.ArrayList;
import java.util.stream.Collectors;

public class Jugador {

    String nombre;
    ArrayList<Jugador> adyacente;
    int velocidad, posesion, remate;

    public Jugador(String nombre, int velocidad, int posesion, int remate) {
        this.adyacente = new ArrayList<>();
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.remate = remate;
        
    }
    public void agregar_adyacente (Jugador v ){
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

    public ArrayList<Jugador> getAdyacente() {
        return adyacente;
    }

    public String toString() {
        return "Vertice{"
                + "dato='" + nombre + '\''
                + ",adyacentes="
                + adyacente.stream().map(Jugador::getNombre).collect(Collectors.joining(", ")) + 
    '}';
    }
    
}
