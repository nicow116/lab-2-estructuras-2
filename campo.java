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