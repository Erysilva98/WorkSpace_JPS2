package command;

import dispositivos.TV;

public class TVComando implements Comando {
    private static final long serialVersionUID = 1L;
    private TV tv;
    private String acao;
    private int valor;

    public static final String LIGAR = "ligar";
    public static final String DESLIGAR = "desligar";
    public static final String SETAR_CANAL = "setar_canal";
    public static final String SETAR_VOLUME = "setar_volume";

    public TVComando(TV tv, String acao, int valor) {
        this.tv = tv;
        this.acao = acao;
        this.valor = valor;
    }

    @Override
    public void executar() {
        switch (acao) {
            case LIGAR:
                tv.on();
                break;
            case DESLIGAR:
                tv.off();
                break;
            case SETAR_CANAL:
                tv.setInputChannel(valor);
                break;
            case SETAR_VOLUME:
                tv.setVolume(valor);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (acao) {
            case LIGAR:
                tv.off();
                break;
            case DESLIGAR:
                tv.on();
                break;
            case SETAR_CANAL:
                // Aqui seria necessário manter o canal anterior, se necessário
                break;
            case SETAR_VOLUME:
                // Aqui seria necessário manter o volume anterior, se necessário
                break;
        }
    }

    @Override
    public String armazenar() {
        return acao + ":" + valor;
    }

    @Override
    public void carregar(String dados) {
        String[] partes = dados.split(":");
        this.acao = partes[0];
        if (partes.length > 1) {
            this.valor = Integer.parseInt(partes[1]);
        }
    }
}
