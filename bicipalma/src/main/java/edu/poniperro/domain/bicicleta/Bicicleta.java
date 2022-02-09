package edu.poniperro.domain.bicicleta;

public class Bicicleta implements Movil{

    // Replace primitives data types, with Object. Objects are wrappers.
    private final Integer id;

    public Bicicleta(int id) {
        this.id = id;
    }

    @Override
    public int getId(){
        // Returns the int primitive value of Integer Object.
        return this.id.intValue();
    }

    @Override
    public
    String toString() {
        // Integer Object has a toString() built-in method.
        return this.id.toString();
    }

}
