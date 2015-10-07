package kohlspos;

/**
 *
 * @author Scott
 */
public class KohlsPOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        
        cr.startSale(new FakeDatabase(), "001");
        cr.addNewItemToSale("100", 2, new FakeDatabase());
        cr.addNewItemToSale("200", 1, new FakeDatabase());
        cr.addNewItemToSale("435", 3, new FakeDatabase());
        cr.printReceipt(new ReceiptOutputStrategyConsoleOutput());
    }
    
}
