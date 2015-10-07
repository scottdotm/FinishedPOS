package kohlspos;

/**
 *
 * @author Scott
 */
public interface DataAccessStrategy {
    public abstract Product findProduct(String productID);
    public abstract Customer findCustomer(String customerID);
}
