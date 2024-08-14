package dispositivos;

public class TV {
    public void on() {
        System.out.println("TV ligada.");
    }

    public void off() {
        System.out.println("TV desligada.");
    }

    public void setInputChannel(int channel) {
        System.out.println("Canal definido para " + channel);
    }

    public void setVolume(int volume) {
        System.out.println("Volume definido para " + volume);
    }
}
