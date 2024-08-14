package command;

import dispositivos.Som;

public class SomCommand implements Comando {
    private static final long serialVersionUID = 1L;
    private Som som;
    private String acao;
    private int valor;

    public static final String LIGAR = "ligar";
    public static final String DESLIGAR = "desligar";
    public static final String SETAR_CD = "setar_cd";
    public static final String SETAR_DVD = "setar_dvd";
    public static final String SETAR_RADIO = "setar_radio";
    public static final String SETAR_VOLUME = "setar_volume";

    public void SomComand (Som som, String acao) {
        this.som = som;
        this.acao = acao;
    }

    public void SomComand (Som som, String acao, int valor) {
        this.som = som;
        this.acao = acao;
        this.valor = valor;
    }

    @Override
    public void executar() {
        switch (acao) {
            case LIGAR:
                som.on();
                break;
            case DESLIGAR:
                som.off();
                break;
            case SETAR_CD:
                som.setCd();
                break;
            case SETAR_DVD:
                som.setDvd();
                break;
            case SETAR_RADIO:
                som.setRadio();
                break;
            case SETAR_VOLUME:
                som.setVolume(valor);
                break;
        }
    }

    @Override
    public void desfazer() {
        switch (acao) {
            case LIGAR:
                som.off();
                break;
            case DESLIGAR:
                som.on();
                break;
            case SETAR_CD:
            case SETAR_DVD:
            case SETAR_RADIO:
                som.off();
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