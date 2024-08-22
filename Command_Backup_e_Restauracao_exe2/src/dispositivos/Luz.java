package dispositivos;

import java.io.Serializable;

public class Luz implements Serializable {
    private static final long serialVersionUID = 1L;

    public void ligar() {
        System.out.println("Luz ligada");
    }

    public void desligar() {
        System.out.println("Luz desligada");
    }
}
