package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;
public class Anclaje {
    

    private Boolean ocupado = false;
    private Movil bici = null;

    Anclaje() {};

    // Object boolean returns value of Object attribute
    boolean isOcupado() {
        return Boolean.valueOf(ocupado);
    }

    Movil getBici() {
        return this.bici;
    }

    // Object boolean method to set object attribute to 'true'
    void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = Boolean.TRUE;
    }

    // Object boolean method to set object attribute to 'true'
    void liberarBici() {
        this.ocupado = Boolean.FALSE;
        this.bici = null;
    }

    @Override
    public String toString() {
        return "ocupado: " + this.ocupado.toString();
    }



}
