package edu.elsmancs.domain.tarjetaUsuario;

public class TarjetaUsuario implements Autenticacion{
    private final String id;
    private boolean activada;

    public TarjetaUsuario(String id, boolean activada) {
        this.id = id;
        this.activada = activada;
    }

    @Override
    public boolean isActivada() {
        return activada;
    }
    @Override
    public String getId() {
        return id;
    }
}
