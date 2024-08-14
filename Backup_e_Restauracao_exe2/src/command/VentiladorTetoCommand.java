package command;

import dispositivos.VentiladorTeto;

public class VentiladorTetoCommand implements Comando { // Adicionei a implementação da interface Comando
    private static final long serialVersionUID = 1L;
    private VentiladorTeto ventiladorTeto;
    private String acao;

    public static final String ALTO = "alto";
    public static final String MEDIO = "medio";
    public static final String BAIXO = "baixo";
    public static final String DESLIGAR = "desligar";

    private int velocidadeAnterior;

    // Construtor corrigido (mudei para um construtor apropriado, removi o retorno
    // void)
    public VentiladorTetoCommand(VentiladorTeto ventiladorTeto, String acao) {
        this.ventiladorTeto = ventiladorTeto;
        this.acao = acao;
    }

    @Override
    public void executar() {
        velocidadeAnterior = ventiladorTeto.getVelocidade(); // Armazena a velocidade anterior
        switch (acao) {
            case ALTO:
                ventiladorTeto.alto();
                break;
            case MEDIO:
                ventiladorTeto.medio();
                break;
            case BAIXO:
                ventiladorTeto.baixo();
                break;
            case DESLIGAR:
                ventiladorTeto.desligar();
                break;
            default:
                System.out.println("Ação desconhecida: " + acao);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (velocidadeAnterior) {
            case VentiladorTeto.ALTO:
                ventiladorTeto.alto();
                break;
            case VentiladorTeto.MEDIO:
                ventiladorTeto.medio();
                break;
            case VentiladorTeto.BAIXO:
                ventiladorTeto.baixo();
                break;
            case VentiladorTeto.DESLIGADO:
                ventiladorTeto.desligar();
                break;
            default:
                System.out.println("Velocidade anterior desconhecida: " + velocidadeAnterior);
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
