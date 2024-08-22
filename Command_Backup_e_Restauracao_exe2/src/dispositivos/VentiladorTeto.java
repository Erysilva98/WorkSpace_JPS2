package dispositivos;

import java.io.Serializable;

public class VentiladorTeto implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int ALTO = 3;
    public static final int MEDIO = 2;
    public static final int BAIXO = 1;
    public static final int DESLIGADO = 0;

    private int velocidade;

    public void alto() {
        velocidade = ALTO;
        System.out.println("Ventilador de teto definido para ALTO");
    }

    public void medio() {
        velocidade = MEDIO;
        System.out.println("Ventilador de teto definido para MÉDIO");
    }

    public void baixo() {
        velocidade = BAIXO;
        System.out.println("Ventilador de teto definido para BAIXO");
    }

    public void desligar() {
        velocidade = DESLIGADO;
        System.out.println("Ventilador de teto desligado");
    }

    public int getVelocidade() {
        return velocidade;
    }
}
