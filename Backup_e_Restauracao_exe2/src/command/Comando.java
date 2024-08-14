package command;

import java.io.Serializable;

public interface Comando extends Serializable {
    void executar();

    void desfazer();

    String armazenar();

    void carregar(String dados);
}
