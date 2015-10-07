package kohlspos;

/**
 *
 * @author Scott
 */
public class LineItem {

    
    private Product product;
    private double qty;
    private final DataAccessStrategy das;

    public LineItem(DataAccessStrategy das, String prodID, double qty) {
        this.das = das;
        this.product = findProduct(prodID);
        setQty(qty);
        
    }

   private Product findProduct(String prodID) {
        return das.findProduct(prodID);
    }

    public double getNormalSubtotal() {
        return product.getPrice() * qty;
    }

    public double getDiscountAmount() {
        return product.getDiscountStrategy().getDiscountProductTotal(product.getPrice(), qty);
    }
    
   
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }

    public final void setQty(double qty) throws IllegalArgumentException {
        if (qty < 0) {
            throw new IllegalArgumentException();
        } else {
            this.qty = qty;
        }
    }

}
