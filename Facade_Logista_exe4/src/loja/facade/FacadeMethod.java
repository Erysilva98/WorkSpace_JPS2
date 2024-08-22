package loja.facade;

import loja.produto.Produto;
import loja.servico.ServicoEstoque;
import loja.servico.ServicoPagamento;
import loja.servico.ServicoRemessa;

public class FacadeMethod {
    public void processarPedido(Produto produto) {
        if (ServicoEstoque.isAvailable(produto)) {

            if (ServicoPagamento.makePayment()) {
                ServicoRemessa.shipProduct(produto);
                System.out.println("Pedido processado com sucesso!");
                
            } else {
                System.out.println("Falha no pagamento.");
            }
        } else {
            System.out.println("Produto não disponível em estoque.");
        }
    }
}
