package edu.elsmancs.domain.estacion;

import java.util.concurrent.ThreadLocalRandom;

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

    public Anclaje[] anclajes() {
        return this.anclajes;
    }

    public int numAnclajes() {
        return this.anclajes.length;
    }

    public void ocuparAnclaje(int numeroAnclaje, Movil bicicleta) {
        this.anclajes[numeroAnclaje].anclarBici(bicicleta);
    }

    public boolean isAnclajeOcupado(int numeroAnclaje) {
        return this.anclajes[numeroAnclaje].isOcupado();
    }

    public void liberarAnclaje(int numeroAnclaje) {
        this.anclajes[numeroAnclaje].liberarBici();
    }

    public Movil getBiciAt(int numeroAnclaje) {
        return this.anclajes[numeroAnclaje].getBici();
    }

    public int seleccionarAnclaje() {
        Integer numeroAnclaje = ThreadLocalRandom.current().nextInt(numAnclajes());
        return numeroAnclaje;
    }

    @Override
    public String toString() {
        return "Numero de anclajes: " + Integer.toString(numAnclajes());
    }
}