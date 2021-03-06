package edu.poniperro.domain.estacion;

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

    public void mostrarBicicleta(Movil bicicleta) {
        System.out.println("bicicleta retirada: " + bicicleta.getId());
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
            // :: is used for method reference, calling objects methods
            Optional<Anclaje> anclajesOcupados = Arrays.stream(anclajes()).filter(Anclaje::isOcupado).findAny();


            if (anclajesOcupados.isPresent()) { // leer anclaje
                mostrarBicicleta(anclajesOcupados.get().getBici());
                anclajesOcupados.get().liberarBici();
            } else {
                System.out.println("No hay bicicletas");
            }
        }
        else {
            System.out.println("Tarjeta de usuario inactiva :(");
        }
    }
    
    public void consultarAnclajes() {

        Arrays.stream(anclajes()).map(a -> Optional.ofNullable(a.getBici())).forEach(bici -> System.out.print("Anclaje " + (bici.isPresent()? bici.get(): "libre")));

    }
  }


