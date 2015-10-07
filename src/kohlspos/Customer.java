package kohlspos;

/**
 *
 * @author Scott
 * 
 */
public class Customer {

    
    private String custID;
    private String custName;

    public Customer(String custID, String custName) {
        setCustomerID(custID);
        setCustomerName(custName);
    }

    public String getCustomerID() {
        return custID;
    }

    public final void setCustomerID(String customerID) throws IllegalArgumentException{
        if (customerID == null || customerID.length() < 0) {
            throw new IllegalArgumentException();
        } else {
            this.custID = customerID;
        }
    }

    public String getCustomerName() {
        return custName;
    }

    public final void setCustomerName(String customerName) throws IllegalArgumentException{
        if (customerName == null || customerName.length() < 0) {
            throw new IllegalArgumentException();
        } else {
            this.custName = customerName;
        }
    }

}
