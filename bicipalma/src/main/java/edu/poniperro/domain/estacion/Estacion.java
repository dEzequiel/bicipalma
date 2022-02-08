package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;
import edu.poniperro.domain.tarjetaUsuario.Autenticacion;

public class Estacion {
    
    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(int id, String direccion, int numeroAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numeroAnclajes);
    }

    public int getId() {
        return this.id;
    }
    
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
        System.out.print("id: " + getId() + " estacion: " + getDireccion() + " anclajes: " + numAnclajes());
    }

    public int anclajesLibres() {
        int numAnclajesLibres = 0;

        for (Anclaje anclaje : anclajes()) {
            numAnclajesLibres = anclaje.isOcupado()? numAnclajesLibres: ++numAnclajesLibres;
        }
        return numAnclajesLibres;
    }

    public void mostrarAnclaje(Movil bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta " + bicicleta.getId() 
                            + " anclada en el anclaje " + numeroAnclaje);
    }

    public void mostrarBicicleta(Movil bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta retirada: " + bicicleta.getId() 
        + " del anclaje: " + numeroAnclaje);
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

    public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjetaUsuario) {
        if (leerTarjetaUsuario(tarjetaUsuario)) {
            boolean biciRetirada = false;

            int posicion = anclajes.seleccionarAnclaje();
			int numeroAnclaje = posicion + 1;


            if (anclajes.isAnclajeOcupado(posicion)) { // leer anclaje
                mostrarBicicleta(anclajes.getBiciAt(posicion), numeroAnclaje);
                anclajes.liberarAnclaje(posicion); // set anclaje
                biciRetirada = true;
            } else; }
        else {
            System.out.println("Tarjeta de usuario inactiva :(");
        }

        }
    
    public void consultarAnclajes() {
        // Recorre el array anclajes y 
        // Muestra si está libre o el id de la bici anclada 

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


