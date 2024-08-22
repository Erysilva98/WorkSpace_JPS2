package command;

import dispositivos.PortaGaragem;

public class PortaGaragemCommand implements Comando {
    private static final long serialVersionUID = 1L;
    private PortaGaragem portaGaragem;
    private String acao;

    public static final String SUBIR = "subir";
    public static final String DESCER = "descer";
    public static final String PARAR = "parar";

    // Corrigi o nome do construtor
    public PortaGaragemCommand(PortaGaragem portaGaragem, String acao) {
        this.portaGaragem = portaGaragem;
        this.acao = acao;
    }

    @Override
    public void executar() {
        switch (acao) {
            case SUBIR:
                portaGaragem.subir();
                break;
            case DESCER:
                portaGaragem.descer();
                break;
            case PARAR:
                portaGaragem.parar();
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (acao) {
            case SUBIR:
                portaGaragem.descer();
                break;
            case DESCER:
                portaGaragem.subir();
                break;
            case PARAR:
                // Nenhuma ação de desfazer específica, então você pode não precisar desfazer
                // para PARAR
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public String armazenar() {
        return acao; // Armazena a ação executada
    }

    @Override
    public void carregar(String dados) {
        this.acao = dados; // Carrega a ação a partir dos dados
    }
}
