package dispositivos;

import java.io.Serializable;

public class BanheiraHidromassagem implements Serializable {
    private static final long serialVersionUID = 1L;

    public void circular() {
        System.out.println("Hottub circulando");
    }

    public void ligarJatos() {
        System.out.println("Jatos da Hottub ligados");
    }

    public void desligarJatos() {
        System.out.println("Jatos da Hottub desligados");
    }

    public void definirTemperatura(int temperatura) {
        System.out.println("Temperatura da Hottub definida para " + temperatura);
    }
}
