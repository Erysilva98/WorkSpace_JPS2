package loja.servico;

public class ServicoPagamento {
    public static boolean makePayment() {
        // Aqui iria a lógica para conectar a um serviço externo de pagamento
        try {
            Thread.sleep(1000);
            System.out.println("Pagamento efetuado com sucesso! \n ...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true; // Simulação de sucesso no pagamento
    }
}
