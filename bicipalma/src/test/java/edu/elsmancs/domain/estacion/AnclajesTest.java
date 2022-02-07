package edu.elsmancs.domain.estacion;
import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import edu.elsmancs.domain.bicicleta.Bicicleta;

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
}
