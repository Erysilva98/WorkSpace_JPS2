package command;

import dispositivos.Luz;

public class LuzCommand implements Comando { 
    private static final long serialVersionUID = 1L;
    private Luz luz;
    private String acao;

    public static final String LIGAR = "ligar";
    public static final String DESLIGAR = "desligar";

    // Corrigi o nome do construtor
    public LuzCommand(Luz luz, String acao) {
        this.luz = luz;
        this.acao = acao;
    }

    @Override
    public void executar() {
        switch (acao) {
            case LIGAR:
                luz.ligar();
                break;
            case DESLIGAR:
                luz.desligar();
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (acao) {
            case LIGAR:
                luz.desligar();
                break;
            case DESLIGAR:
                luz.ligar();
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
