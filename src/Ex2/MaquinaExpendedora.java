package Ex2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MaquinaExpendedora implements Serializable {


    private ArrayList<Refresco> refrescos;

    private final Lock lock = new ReentrantLock();

    public MaquinaExpendedora() {

        refrescos = new ArrayList<>();

        Collections.addAll(refrescos,
                new Refresco("Coca-Cola"), new Refresco("Fanta"), new Refresco("Sprite"),
                new Refresco("Tónica"), new Refresco("Nestea"), new Refresco("Cerveza"),
                new Refresco("Zumo"), new Refresco("Agua"));

    }

    public synchronized int obtenerCantidadRefrescos() {
        return refrescos.size();
    }

    public synchronized Refresco dispensarRefresco() {
        if (refrescos.isEmpty()) {
            return null;
        }
        return refrescos.remove(0);
    }


}
