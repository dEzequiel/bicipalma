package edu.elsmancs.domain.estacion;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.elsmancs.domain.bicicleta.Bicicleta;

public class AnclajeTest {
    

    @Test
    public void isOcupado () {
        Anclaje anclajeTest = new Anclaje();
        Bicicleta bici = new Bicicleta(1);

        anclajeTest.anclarBici(bici);

        assertEquals(true, anclajeTest.isOcupado());
    }

    @Test
    public void liberarBici() {
        Anclaje anclajeTest = new Anclaje();
        Bicicleta bici = new Bicicleta(1);
        
        anclajeTest.anclarBici(bici);
        anclajeTest.liberarBici();

        assertEquals(false, anclajeTest.isOcupado());
        assertEquals(null, anclajeTest.getBici());

    }
}
