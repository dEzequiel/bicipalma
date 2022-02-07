package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;
public class Anclaje {
    

    private boolean ocupado = false;
    private Movil bici = null;

    Anclaje() {};

    boolean isOcupado() {
        return this.ocupado;
    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    void liberarBici() {
        this.ocupado = false;
        this.bici = null;
    }

    @Override
    public String toString() {
        return "ocupado: " + Boolean.toString(isOcupado());
    }



}
