package dispositivos;

import java.io.Serializable;

public class Alarme implements Serializable {
    private static final long serialVersionUID = 1L;

    public void ativar() {
        System.out.println("Sistema de alarme ativado");
    }

    public void desativar() {
        System.out.println("Sistema de alarme desativado");
    }
}
