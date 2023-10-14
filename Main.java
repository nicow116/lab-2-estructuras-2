public class Main {
    public static void main(String[] args) {
        int contador = 0;
        String[][] jugadores = Archivo.CrearEquipos();
        ;
        Jugador[] equipo = new Jugador[22];
        System.out.println(jugadores.length);

        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i][0] != null) {
                contador = contador + 1;
            }
        }

        for (int i = 0; i < contador; i++) {
            equipo[i] = new Jugador(jugadores[i][0], Integer.parseInt(jugadores[i][1]),
                    Integer.parseInt(jugadores[i][2]), Integer.parseInt(jugadores[i][3]));
            System.out.println("Did it");
        }
        System.out.println("Clear");

    }
}
