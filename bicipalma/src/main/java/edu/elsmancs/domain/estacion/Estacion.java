package edu.elsmancs.domain.estacion;

import edu.elsmancs.domain.tarjetaUsuario.Autenticacion;

public class Estacion implements Autenticacion{
    
    private final int id;
    private final String direccion;
    public final Anclajes anclajes;

    public Estacion(int id, String direccion, int numeroAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numeroAnclajes);
    }

    


}
