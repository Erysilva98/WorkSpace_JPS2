import loja.facade.FacadeMethod;
import loja.produto.Produto;

public class App {
    public static void main(String[] args) {
        Produto produto = new Produto(1, "Computador Gamer ");

        FacadeMethod pedido = new FacadeMethod();
        pedido.processarPedido(produto); 
    }
}
