package kohlspos;

/**
 *
 * @author Scott
 */
public class CashRegister {
    private Receipt receipt;
    
    
    public void startSale(DataAccessStrategy das, String custID) {
        receipt = new Receipt(das, custID);
    }
    
    public void addNewItemToSale(String prodID, int qty, DataAccessStrategy das){
        receipt.addNewLineItem(das, prodID, qty);
    }
    
    public void printReceipt(ReceiptOutputStrategy ros){
        ros.printOutReceipt(receipt.sendReceiptToPrint());
    }
}
