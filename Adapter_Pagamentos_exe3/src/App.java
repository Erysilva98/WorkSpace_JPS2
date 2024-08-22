import adapter.MPayToPPayAdapter;
import model.MpayImpl;
import model.PPay;

public class App {
    public static void main(String[] args) {
        MpayImpl mPay = new MpayImpl();
        mPay.setCreditCardNo("1234567890123456");
        mPay.setCustomerName("John Doe");
        mPay.setCardExpMonth("06");
        mPay.setCardExpYear("2024");
        mPay.setCardCVVNo((short) 123);
        mPay.setAmount(100.0);

        PPay pPay = new MPayToPPayAdapter(mPay);
        testPPay(pPay);
    }

    public static void testPPay(PPay pp) {
        System.out.println("Nome no Cartao: " + pp.getCardOwnerName());
        System.out.println("Numero do Cartao: " + pp.getCustCardNo());
        System.out.println("Data de Validade: " + pp.getCardExpMonthDate());
        System.out.println("Numero CVV: " + pp.getCVVNo());
        System.out.println("Valor Total: " + pp.getTotalAmount());
    }
}
