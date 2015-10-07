package kohlspos;

/**
 *
 * @author Scott
 */
public class FakeDatabase implements DataAccessStrategy {
    
    private Product[] products ={
        new Product("100", 25.00, "Hoodie               ", new NoDiscount()),
        new Product("200", 15.00, "T-Shirt              ", new PercentOffDiscount(5)),
        new Product("435", 15.95, "Test Product #1      ", new PercentOffDiscount(0.15)),
        new Product("562", 15.95, "Test Product #2      ", new QtyDiscount(3,3))
    };
    
    private Customer[] customers ={
        new Customer("001", "Scott"),
        new Customer("002", "Jimmbo"),
        new Customer("003", "Slim")    
    };
    
    
    
    @Override
    public final Product findProduct(String productID) throws IllegalArgumentException {
        if (productID == null || productID.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        Product product = null;
        
        for(Product prod: products){
            if(productID.equals(prod.getProductID())){
                product = prod;
                break;
            }
        }
        return product;
    }
    
    @Override
    public final Customer findCustomer(String customerID) throws IllegalArgumentException {
        if (customerID == null || customerID.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        Customer customer = null;
        
        for(Customer cust: customers){
            if(customerID.equals(cust.getCustomerID())){
                customer = cust;
                break;
            }
        }
        return customer;
    }
}
