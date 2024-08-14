package command;

import dispositivos.BanheiraHidromassagem;

public class BanheiraHidromassagemCommand implements Comando {
    private static final long serialVersionUID = 1L;
    private BanheiraHidromassagem banheira;
    private String acao;
    private int temperatura;

    public static final String CIRCULAR = "circular";
    public static final String LIGAR_JATOS = "ligar_jatos";
    public static final String DESLIGAR_JATOS = "desligar_jatos";
    public static final String DEFINIR_TEMPERATURA = "definir_temperatura";

    // Corrigi o nome do construtor
    public BanheiraHidromassagemCommand(BanheiraHidromassagem banheira, String acao) {
        this.banheira = banheira;
        this.acao = acao;
    }

    public BanheiraHidromassagemCommand(BanheiraHidromassagem banheira, String acao, int temperatura) {
        this.banheira = banheira;
        this.acao = acao;
        this.temperatura = temperatura;
    }

    @Override
    public void executar() {
        switch (acao) {
            case CIRCULAR:
                banheira.circular();
                break;
            case LIGAR_JATOS:
                banheira.ligarJatos();
                break;
            case DESLIGAR_JATOS:
                banheira.desligarJatos();
                break;
            case DEFINIR_TEMPERATURA:
                banheira.definirTemperatura(temperatura);
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (acao) {
            case CIRCULAR:
            case LIGAR_JATOS:
            case DESLIGAR_JATOS:
                banheira.desligarJatos();
                break;
            case DEFINIR_TEMPERATURA:
                // Aqui seria necessário manter a temperatura anterior, se necessário
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public String armazenar() {
        return acao + ":" + temperatura;
    }

    @Override
    public void carregar(String dados) {
        String[] partes = dados.split(":");
        this.acao = partes[0];
        if (partes.length > 1) {
            this.temperatura = Integer.parseInt(partes[1]);
        }
    }
}
