package edu.poniperro.domain.estacion;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.poniperro.domain.bicicleta.Bicicleta;

import edu.poniperro.domain.tarjetaUsuario.TarjetaUsuario;

public class EstacionTest {

    @Test
    public void creacionEstacion() {
        Estacion estacion = new Estacion(1, "Manacor", 3);
        assertEquals(1, estacion.getId());
        assertEquals("Manacor", estacion.getDireccion());
        assertEquals(3, estacion.numAnclajes());
    }

    @Test
    public void checkAnclajesLongitud() {
        Estacion estacion = new Estacion(1, "Manacor", 3);
        assertEquals(3, estacion.numAnclajes());
    }
    
    @Test
    public void consultarAnclajesLibres() {
        Estacion estacion = new Estacion(1, "Manacor", 3);
        Bicicleta bici = new Bicicleta(1);
        estacion.anclarBicicleta(bici);

        assertEquals(2, estacion.anclajesLibres());
    }

    @Test
    public void checkTarjetaUsuario() {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("Eze", false);
        Estacion estacion = new Estacion(1, "Manacor", 3);
        assertEquals(false, estacion.leerTarjetaUsuario(tarjetaUsuario));
    }

    @Test
    public void retirarBicicleta() {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("Eze", true);
        Estacion estacion = new Estacion(1, "Manacor", 3);
        Bicicleta bici = new Bicicleta(1);
        Bicicleta bici2 = new Bicicleta(2);
        estacion.anclarBicicleta(bici);
        estacion.anclarBicicleta(bici2);

        assertEquals(1, estacion.anclajesLibres());

        estacion.retirarBicicleta(tarjetaUsuario);
        assertEquals(2, estacion.anclajesLibres());


    }
}
