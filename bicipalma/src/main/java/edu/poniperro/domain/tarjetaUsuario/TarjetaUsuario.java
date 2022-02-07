package edu.poniperro.domain.tarjetaUsuario;

public class TarjetaUsuario implements Autenticacion{
    private final String id;
    private boolean activada;

    public TarjetaUsuario(String id, boolean activada) {
        this.id = id;
        this.activada = activada;
    }

    @Override
    public boolean isActivada() {
        return this.activada;
    }
    @Override
    public void setActivada(boolean estado)  {
        this.activada = true;
    }

    @Override
	public String toString() {
		return this.id;
	}

    @Override
    public String getId() {
        return this.id;
    }
}
