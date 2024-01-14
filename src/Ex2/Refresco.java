package Ex2;

import java.io.Serializable;

public class Refresco implements Serializable {

    private static final long serialVersionUID = 1l;

    private String nombre;

    public Refresco(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;

    }


}
