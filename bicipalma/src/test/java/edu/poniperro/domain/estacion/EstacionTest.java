package edu.poniperro.domain.estacion;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.poniperro.domain.bicicleta.Bicicleta;
import edu.poniperro.domain.estacion.Anclajes;
import edu.poniperro.domain.estacion.Estacion;

public class EstacionTest {

    @Test
    public void checkingAnclajesLibres() {
        Anclajes anclajes = new Anclajes(3);
        Bicicleta bici = new Bicicleta(1);
        Estacion estacion = new Estacion(1, "manacor", 3);
        anclajes.ocuparAnclaje(1, bici);

        assertEquals(3, estacion.anclajesLibres());
    }
}
