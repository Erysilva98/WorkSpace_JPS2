package loja.servico;

import loja.produto.Produto;

public class ServicoRemessa {
    public static void shipProduct(Produto product) {
        // Aqui iria a lógica para conectar com um serviço externo de logística
        System.out.println("Produto " + product.name + " enviado para o endereço do cliente.");
    }
}
