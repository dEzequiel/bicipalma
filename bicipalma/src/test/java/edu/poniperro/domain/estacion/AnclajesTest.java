package edu.poniperro.domain.estacion;
import static org.junit.Assert.*;

import org.junit.Test;

import edu.poniperro.domain.bicicleta.Bicicleta;
import edu.poniperro.domain.estacion.Anclajes;

public class AnclajesTest {

    @Test
    public void espaciosAnclajes() {
        Anclajes anclajes = new Anclajes(3);
        assertEquals(3, anclajes.numAnclajes());
    }   

    @Test
    public void isAnclajeOcupado() {
        Anclajes anclajes = new Anclajes(3);
        Bicicleta bici = new Bicicleta(1);
        Bicicleta bici2 = new Bicicleta(1);

        anclajes.ocuparAnclaje(1, bici);
        anclajes.ocuparAnclaje(2, bici2);

        assertEquals(true, anclajes.isAnclajeOcupado(1));
        assertEquals(true, anclajes.isAnclajeOcupado(2));
        
    }

    @Test
    public void liberarAnclaje() {
        Anclajes anclajes = new Anclajes(3);
        Bicicleta bici = new Bicicleta(1);
        Bicicleta bici2 = new Bicicleta(1);

        anclajes.ocuparAnclaje(1, bici);
        anclajes.ocuparAnclaje(2, bici2);

        anclajes.liberarAnclaje(1);
        anclajes.liberarAnclaje(2);

        assertEquals(false, anclajes.isAnclajeOcupado(1));
        assertEquals(false, anclajes.isAnclajeOcupado(2));
        
    }

    @Test
    public void getBiciAt() {
        Anclajes anclajes = new Anclajes(3);
        Bicicleta bici = new Bicicleta(1);

        anclajes.ocuparAnclaje(1, bici);

        assertEquals(bici, anclajes.getBiciAt(1));
        assertEquals(null, anclajes.getBiciAt(2));
    }
}
