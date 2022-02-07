package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;
import edu.poniperro.domain.tarjetaUsuario.Autenticacion;

public class Estacion {
    
    private final int id;
    private final String direccion;
    public final Anclajes anclajes;

    public Estacion(int id, String direccion, int numeroAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numeroAnclajes);
    }

    private int getId() {
        return this.id;
    }
    
    private String getString() {
        return this.direccion;
    }

    private Anclaje[] anclajes() {
        return this.anclajes.anclajes();
    }

    private int numAnclajes() {
        return this.anclajes.numAnclajes();
    }

    public void consultarEstacion() {
        System.out.print(this);
    }

    public int anclajesLibres() {
        int numAnclajesLibres = 0;

        for (Anclaje anclaje : anclajes()) {
            numAnclajesLibres = anclaje.isOcupado()? numAnclajesLibres: ++numAnclajesLibres;
        }
        return numAnclajesLibres;
    }

    private void mostrarAnclaje(Movil bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta " + bicicleta.getId() 
                            + " anclada en el anclaje " + numeroAnclaje);
    }

    public void anclarBicicleta(Movil bicicleta) {

        int posicion = 0;
        int numeroAnclaje = 1;

        for(Anclaje anclaje : anclajes()) {
            if(!anclaje.isOcupado()) {
                anclajes.ocuparAnclaje(posicion, bicicleta);
                mostrarAnclaje(bicicleta, numeroAnclaje);
                break;
            } else {
                posicion++;
            }
            numeroAnclaje++;
        }

        



    }

}
