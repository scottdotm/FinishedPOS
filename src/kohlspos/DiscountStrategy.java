package kohlspos;

/**
 *
 * @author Scott
 */
public interface DiscountStrategy {
    double getAmountSaved(double unitPrice, double qty);

    double getDiscountProductTotal(double unitPrice, double qty);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
}
