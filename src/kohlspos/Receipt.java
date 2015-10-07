package kohlspos;

import java.text.NumberFormat;

/**
 *
 * @author Scott
 */
public class Receipt {

    private LineItem[] lineItems = new LineItem[0];
    private DataAccessStrategy das;
    private final Customer customer;
    

    public Receipt(DataAccessStrategy das, String customerID) {
        this.das = das;
        this.customer = findCustomer(customerID);

    }

    private final Customer findCustomer(String customerID) {
        return das.findCustomer(customerID);
    }

    public void addNewLineItem(DataAccessStrategy das, String prodID, double qty) {
        LineItem item = new LineItem(das, prodID, qty);
        LineItem[] temp = new LineItem[(lineItems.length + 1)];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = item;
        lineItems = temp;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) throws IllegalArgumentException{
        if(lineItems == null){
            throw new IllegalArgumentException();
        }
        this.lineItems = lineItems;
    }

    public DataAccessStrategy getDas() {
        return das;
    }

    public void setDas(DataAccessStrategy das) throws IllegalArgumentException {
        if(das == null){
            throw new IllegalArgumentException();
        }
        this.das = das;
    }

    public double getTotalBeforeDiscount() {
        double total = 0;
        for (LineItem lineItem : lineItems) {
            total += lineItem.getNormalSubtotal();
        }

        return total;
    }

    public double getTotalDiscountAmount() {
        double total = 0;
        for (LineItem lineItem : lineItems) {
            total += lineItem.getDiscountAmount();
        }

        return total;
    }

    public double getReceiptTotal() {
        double total = 0;

        total = getTotalBeforeDiscount() - getTotalDiscountAmount();

        return total;
    }


    private String formatReceipt() {

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        final String ONE_LINE = "\n";
        final String TWO_LINE = "\n\n";

        StringBuilder customerReceipt = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        customerReceipt.append("Customer ID: ").append(customer.getCustomerID()).append("\t\t\tCustomer Name: ").append(customer.getCustomerName()).append(ONE_LINE);
        customerReceipt.append("------------------------------------------------------------------------").append(ONE_LINE);

        customerReceipt.append("ID#").append("\t").append("Description").append("\t\t").append("Qty").append("\t\t").append("Price").append("\t\t").append("Discount").append(ONE_LINE);
        customerReceipt.append("------------------------------------------------------------------------").append(ONE_LINE);
        for (LineItem lineItem : lineItems) {
            customerReceipt.append(lineItem.getProduct().getProductID()).append("\t").append(lineItem.getProduct().getDescription()).append("\t").append(lineItem.getQty()).append("\t\t").append(nf.format(lineItem.getProduct().getPrice())).append("\t\t").append(nf.format(lineItem.getDiscountAmount())).append(ONE_LINE);
        }

        customerReceipt.append(TWO_LINE);
        customerReceipt.append("------------------------------------------------------------------------").append(ONE_LINE);

        customerReceipt.append("\t\t\t\t\t Net Total: \t").append(nf.format(getTotalBeforeDiscount())).append(ONE_LINE);
        customerReceipt.append("\t\t\t\t\t Total Saved: \t").append(nf.format(getTotalDiscountAmount())).append(ONE_LINE);
        customerReceipt.append("\t\t\t\t\t Total Due: \t").append(nf.format(getReceiptTotal())).append(ONE_LINE);

        return customerReceipt.toString();
    }

    public String sendReceiptToPrint() {
         return formatReceipt();
    }

}
