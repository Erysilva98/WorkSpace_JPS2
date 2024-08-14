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

        // Criando o controle remoto
        ControleRemoto controle = new ControleRemoto();

        // Criando comandos para os dispositivos
        Comando ligarLuz = new LuzCommand(luz, LuzCommand.LIGAR);
        Comando desligarLuz = new LuzCommand(luz, LuzCommand.DESLIGAR);
        Comando ativarAlarme = new AlarmeCommand(alarme, AlarmeCommand.ATIVAR);
        Comando desativarAlarme = new AlarmeCommand(alarme, AlarmeCommand.DESATIVAR);
        Comando ligarJatosBanheira = new BanheiraHidromassagemCommand(banheira, BanheiraHidromassagemCommand.LIGAR_JATOS);
        Comando subirPortaGaragem = new PortaGaragemCommand(portaGaragem, PortaGaragemCommand.SUBIR);
        Comando ligarVentiladorAlto = new VentiladorTetoCommand(ventilador, VentiladorTetoCommand.ALTO);

        // Executando comandos e armazenando no controle remoto
        controle.setComando(ligarLuz);
        controle.setComando(ativarAlarme);
        controle.setComando(ligarJatosBanheira);
        controle.setComando(subirPortaGaragem);
        controle.setComando(ligarVentiladorAlto);

        // Desfazendo os últimos comandos
        controle.desfazerUltimoComando();
        controle.desfazerUltimoComando();

        // Armazenando o histórico de comandos
        controle.armazenarHistorico("historico_comandos.ser");

        // Simulando uma falha e carregando o histórico
        System.out.println("Simulando uma falha e recarregando os comandos...");
        controle.carregarHistorico("historico_comandos.ser");
    }
}
