import command.*;
import dispositivos.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Instanciando os dispositivos
        Luz luz = new Luz();
        Alarme alarme = new Alarme();
        BanheiraHidromassagem banheira = new BanheiraHidromassagem();
        PortaGaragem portaGaragem = new PortaGaragem();
        VentiladorTeto ventilador = new VentiladorTeto();
        TV tv = new TV();

        // Criando o controle remoto
        ControleRemoto controle = new ControleRemoto();

        // Criando comandos para "Chegar em casa"
        Comando abrirPortaGaragem = new PortaGaragemCommand(portaGaragem, PortaGaragemCommand.SUBIR);
        Comando desativarAlarme = new AlarmeCommand(alarme, AlarmeCommand.DESATIVAR);
        Comando ligarLuz = new LuzCommand(luz, LuzCommand.LIGAR);
        Comando fecharPortaGaragem = new PortaGaragemCommand(portaGaragem, PortaGaragemCommand.DESCER);
        Comando ligarTV = new TVComando(tv, TVComando.LIGAR, 0);
        Comando ligarVentilador = new VentiladorTetoCommand(ventilador, VentiladorTetoCommand.ALTO);
        Comando ligarBanheira = new BanheiraHidromassagemCommand(banheira, BanheiraHidromassagemCommand.LIGAR_JATOS);

        // Simulando chegada em casa
        System.out.println("\n Chegar em casa:");
        controle.setComando(abrirPortaGaragem);
        controle.setComando(desativarAlarme);
        controle.setComando(ligarLuz);
        controle.setComando(fecharPortaGaragem);
        controle.setComando(ligarTV);
        controle.setComando(ligarVentilador);
        controle.setComando(ligarBanheira);

        // Desfazendo os últimos comandos
        controle.desfazerUltimoComando();
        controle.desfazerUltimoComando();

        // Armazenando o histórico de comandos
        controle.armazenarHistorico("historico_comandos.ser");

        // Simulando uma falha e carregando o histórico
        System.out.println("\n Simulando uma falha e recarregando os comandos... \n");
        controle.carregarHistorico("historico_comandos.ser");
    }
}
