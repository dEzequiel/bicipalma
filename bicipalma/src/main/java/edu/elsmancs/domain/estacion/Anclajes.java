package edu.elsmancs.domain.estacion;

import edu.elsmancs.domain.bicicleta.Movil;

public class Anclajes {

    private final Anclaje[] anclajes;

    Anclajes(int anclajesTotales) {
        this.anclajes = new Anclaje[anclajesTotales];
        crearAnclajes();
    }

    private void crearAnclajes() {
        for (int i = 0; i < anclajes.length; i++) {
            this.anclajes[i] = new Anclaje();
        }
    }

    public Anclajes[] anclajes() {
        return this.anclajes();
    }

    public int numAnclajes() {
        return this.anclajes.length;
    }

    public void ocuparAnclaje(int numeroAnclaje, Movil bicicleta) {
        this.anclajes[numeroAnclaje].anclarBici(bicicleta);
    }

 
}
