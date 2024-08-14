import processadorTexto.ProcessadorDeTexto;
import processadorTexto.TudoMaiuscula;
import processadorTexto.TudoMinuscula;

public class App {
    public static void main(String[] args) throws Exception {
        ProcessadorDeTexto tudoMaiuscula = new TudoMaiuscula();
        ProcessadorDeTexto tudoMinuscula = new TudoMinuscula();

        String texto = "Ola Mundo!";

        System.out.println("Texto Original: " + texto);
        System.out.println("Texto em Maiusculas: " + tudoMaiuscula.processarTexto(texto));
        System.out.println("Texto em Minusculas: " + tudoMinuscula.processarTexto(texto));
    }
}
