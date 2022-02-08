package edu.poniperro.domain.estacion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

import edu.poniperro.domain.bicicleta.Movil;
import edu.poniperro.domain.tarjetaUsuario.Autenticacion;

public class Estacion {
    
    private final Integer id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(Integer id, String direccion, Integer numeroAnclajes) {
        this.id = Integer.valueOf(id);
        this.direccion = direccion;
        this.anclajes = new Anclajes(Integer.valueOf(numeroAnclajes));
    }

    public int getId() {
        return this.id;
    }

    // Stupid method just for debugging with wrapper
    public String getDireccion() {
        return this.direccion;
    }

    public Anclaje[] anclajes() {
        return this.anclajes.anclajes();
    }

    public int numAnclajes() {
        return this.anclajes.numAnclajes();
    }

    public void consultarEstacion() {
        System.out.print("id: " + Integer.toString(this.id) + " estacion: " + getDireccion()+ " anclajes: " + toString());
    }

    public long anclajesLibres() {

        // STREAMS are use for doing aggregate operations on data elements.
        // otherwise COLLECTIONS are use for store data.

        // STREAMS pull data from a source and pass them operations in each element.
        // STREAMS iterate inside collections from you, external iteration vs internal iteration.
        // STREAMS can compute in parallel
        //default method called count() that returns a long value indicating the number of matching items in the stream.
        return Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).count(); 
    }

    public void mostrarAnclaje(Movil bicicleta, Integer numeroAnclaje) {
        System.out.println("bicicleta " + bicicleta.getId() 
                            + " anclada en el anclaje " + Integer.toString(numeroAnclaje));
    }

    public void mostrarBicicleta(Movil bicicleta, Integer numeroAnclaje) {
        System.out.println("bicicleta retirada: " + bicicleta.getId() 
        + " del anclaje: " + Integer.toString(numeroAnclaje));
    }

    public void anclarBicicleta(Movil bicicleta) {

        Optional<Anclaje> anclajeLibre = Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).findAny();

        // Iterate over Optional element, if element is present in hole, get that hole and apply a method.
        if (anclajeLibre.isPresent()) {
            anclajeLibre.get().anclarBici(bicicleta);
        } else {
            System.out.println("No existen anclajes disponibles para bici " + bicicleta);
        }
}

    public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjetaUsuario) {
        if (leerTarjetaUsuario(tarjetaUsuario)) {
            Boolean biciRetirada = Boolean.FALSE;

            int posicion = anclajes.seleccionarAnclaje();
			int numeroAnclaje = posicion + 1;


            if (anclajes.isAnclajeOcupado(posicion)) { // leer anclaje
                mostrarBicicleta(anclajes.getBiciAt(posicion), numeroAnclaje);
                anclajes.liberarAnclaje(posicion); // set anclaje
                biciRetirada = Boolean.TRUE;
            } else; }
        else {
            System.out.println("Tarjeta de usuario inactiva :(");
        }

        }
    
    public void consultarAnclajes() {

        int posicion = 0;
        int numeroAnclaje = 0;

        for (Anclaje anclaje : anclajes()) {
            numeroAnclaje = posicion + 1;
            if (anclaje.isOcupado()) {
                System.out.println("Anclaje " + numeroAnclaje + " " + anclaje.getBici().getId());
            } else {
                System.out.println("Anclaje " + numeroAnclaje + " " + " libre");
            }
            posicion++;
        }
    }
  }


