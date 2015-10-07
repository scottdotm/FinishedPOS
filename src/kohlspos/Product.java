package kohlspos;

/**
 *
 * @author Scott
 */
public class Product {
    
    private String productID;
    private double price;
    private String description;
    private DiscountStrategy discount;

    public Product(String productID, double price, String description, DiscountStrategy discount) {
        setProductID(productID);
        setPrice(price);
        setDescription(description);
        setDiscountStrategy(discount);
    }

    public String getProductID() {
        return productID;
    }

    public final void setProductID(String productID) throws IllegalArgumentException {
        if (productID == null || productID.length() < 0) {
            throw new IllegalArgumentException();
            
        } else {
            this.productID = productID;
        }
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
           throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
    }

    public String getDescription() {
        return description;
    }

    public final void setDescription(String description) throws IllegalArgumentException {
        if (description == null || description.length() < 0) {
            throw new IllegalArgumentException();
        } else {
            this.description = description;
        }
    }

    public DiscountStrategy getDiscountStrategy() {
        return discount;
    }

    public void setDiscountStrategy(DiscountStrategy discount) throws IllegalArgumentException{
        if(discount == null){
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }

}
