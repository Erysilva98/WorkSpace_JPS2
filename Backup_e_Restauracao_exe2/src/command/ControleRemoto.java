package command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControleRemoto {
    private List<Comando> historico = new ArrayList<>();

    public void setComando(Comando comando) {
        System.out.println("Executando comando: " + comando.armazenar());
        historico.add(comando);
        comando.executar();
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            Comando comando = historico.remove(historico.size() - 1);
            System.out.println("Desfazendo comando: " + comando.armazenar());
            comando.desfazer();
        } else {
            System.out.println("Nenhum comando para desfazer.");
        }
    }

    public void armazenarHistorico(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(historico);
            System.out.println("Historico armazenado em: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarHistorico(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            List<Comando> comandos = (List<Comando>) in.readObject();
            for (Comando comando : comandos) {
                System.out.println("Carregando e executando comando: " + comando.armazenar());
                comando.executar();
            }
            historico.addAll(comandos);
            System.out.println("Historico carregado de: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
