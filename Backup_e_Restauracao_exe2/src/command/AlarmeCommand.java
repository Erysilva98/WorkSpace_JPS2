package command;

import dispositivos.Alarme;

public class AlarmeCommand implements Comando {
    private static final long serialVersionUID = 1L;
    private Alarme alarme;
    private String acao;

    public static final String ATIVAR = "ativar";
    public static final String DESATIVAR = "desativar";

    // Corrigi o nome do construtor
    public AlarmeCommand(Alarme alarme, String acao) {
        this.alarme = alarme;
        this.acao = acao;
    }

    @Override
    public void executar() {
        switch (acao) {
            case ATIVAR:
                alarme.ativar();
                break;
            case DESATIVAR:
                alarme.desativar();
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (acao) {
            case ATIVAR:
                alarme.desativar();
                break;
            case DESATIVAR:
                alarme.ativar();
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public String armazenar() {
        return acao;
    }

    @Override
    public void carregar(String dados) {
        this.acao = dados;
    }
}
