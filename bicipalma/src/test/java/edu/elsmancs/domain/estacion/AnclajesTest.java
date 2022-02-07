package edu.elsmancs.domain.estacion;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.elsmancs.domain.bicicleta.Bicicleta;

public class AnclajesTest {

    @Test
    public void espaciosAnclajes() {
        Anclajes anclajes = new Anclajes(3);
        assertEquals(3, anclajes.numAnclajes());
    }    
    
}
