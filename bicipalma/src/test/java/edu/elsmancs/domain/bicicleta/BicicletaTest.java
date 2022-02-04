package edu.elsmancs.domain.bicicleta;
import static org.junit.Assert.*;
import org.junit.Test;

public class BicicletaTest {
    
    @Test
    public void createBicicleta() {
        Bicicleta bici = new Bicicleta(1);
        assertEquals(1, bici.getId());
    }

    @Test 
    public void toStringMethod() {
        Bicicleta bici = new Bicicleta(1);
        System.out.print(bici.getId());
    }

}
