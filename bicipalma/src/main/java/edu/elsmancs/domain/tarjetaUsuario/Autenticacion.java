package edu.elsmancs.domain.tarjetaUsuario;

public interface Autenticacion {
    boolean isActivada();
    String getId();
    void setActivada(boolean estado);
}
