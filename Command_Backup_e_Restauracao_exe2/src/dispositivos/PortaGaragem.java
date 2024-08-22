package dispositivos;

import java.io.Serializable;

public class PortaGaragem implements Serializable {
    private static final long serialVersionUID = 1L;

    public void subir() {
        System.out.println("Porta da garagem aberta");
    }

    public void descer() {
        System.out.println("Porta da garagem fechada");
    }

    public void parar() {
        System.out.println("Porta da garagem parada");
    }
}
