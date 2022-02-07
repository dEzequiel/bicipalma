package edu.elsmancs.domain.estacion;

import edu.elsmancs.domain.bicicleta.Movil;
import edu.elsmancs.domain.tarjetaUsuario.Autenticacion;

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

    private Anclajes[] anclajes() {
        return this.anclajes.anclajes();
    }

    private int numAnclajes() {
        return this.anclajes.numAnclajes();
    }


}
