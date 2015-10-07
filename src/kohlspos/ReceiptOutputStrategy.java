package kohlspos;

/**
 * This interface is for general use for any type of receipt output.
 *
 * @author Adam Tausch
 */
public interface ReceiptOutputStrategy {

    /**
     * Method used for printing out receipt.
     *
     * @param receiptData - Used to pass a toString() to form an output.
     */
    public abstract void printOutReceipt(String receiptData);

    /**
     * Method used for printing out error messages.
     *
     * @param errorMessage - Used to pass a toString() to form an error output.
     */
    public abstract void printErrorMessages(String errorMessages);
}
