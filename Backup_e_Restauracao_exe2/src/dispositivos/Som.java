package dispositivos;

public class Som {
    public void on() {
        System.out.println("Som ligado.");
    }

    public void off() {
        System.out.println("Som desligado.");
    }

    public void setCd() {
        System.out.println("CD selecionado.");
    }

    public void setDvd() {
        System.out.println("DVD selecionado.");
    }

    public void setRadio() {
        System.out.println("Rádio selecionado.");
    }

    public void setVolume(int volume) {
        System.out.println("Volume do som definido para " + volume);
    }
}
