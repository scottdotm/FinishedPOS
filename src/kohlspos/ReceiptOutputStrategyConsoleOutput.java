package kohlspos;

/**
 * This class is an output strategy using console as the output method.
 * @author Scott
 */
public class ReceiptOutputStrategyConsoleOutput implements ReceiptOutputStrategy{
    private final String START_ERROR = "============ THERE WAS AN ERROR ============";
    private final String END_ERROR = "============ END OF ERROR ============";
    /**
     * Method used for printing out receipt.
     *
     * @param receiptData - Used to pass a toString() to form an output.
     */
    @Override
    public void printOutReceipt(String receiptData) {
        System.out.println(receiptData);
    }
    /**
     * Method used for printing out error messages.
     *
     * @param errorMessage - Used to pass a toString() to form an error output.
     */
    @Override
    public void printErrorMessages(String errorMessages) {
        System.out.println(START_ERROR);
        System.out.println(errorMessages);
        System.out.println(END_ERROR);
    }
}
