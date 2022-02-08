package edu.poniperro.domain.tarjetaUsuario;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.poniperro.domain.tarjetaUsuario.TarjetaUsuario;

public class TarjetaUsuarioTest {
    
    @Test
    public void createTarjetaUsuario() {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("Eze", false);
        assertEquals("Eze", tarjetaUsuario.getId());
        assertEquals(false, tarjetaUsuario.isActivada());
    }  

    @Test
    public void setTarjetaUsuario()  {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("Eze", false);
        tarjetaUsuario.setActivada(true);
        assertEquals(true, tarjetaUsuario.isActivada());
    }

    @Test 
    public void toStringMethod() {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("Eze", false);
        System.out.print(tarjetaUsuario.getId());
    }

}
