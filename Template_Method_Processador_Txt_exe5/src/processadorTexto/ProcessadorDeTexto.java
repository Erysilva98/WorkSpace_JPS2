package processadorTexto;
public abstract class ProcessadorDeTexto {
    public final String processarTexto(String entrada) {
        char[] caracteres = extrairCaracteres(entrada);
        char[] caracteresConvertidos = converterCaracteres(caracteres);
        return juntarCaracteres(caracteresConvertidos);
    }

    private char[] extrairCaracteres(String texto) {
        return texto.toCharArray();
    }

    protected abstract char[] converterCaracteres(char[] chars);

    private String juntarCaracteres(char[] chars) {
        return new String(chars);
    }
}
