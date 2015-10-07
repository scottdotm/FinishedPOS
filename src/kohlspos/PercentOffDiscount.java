package kohlspos;

/**
 *
 * @author Scott
 * 
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate;
    
    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public final double getDiscountProductTotal(double unitPrice, double qty) {
        return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    @Override
    public final double getAmountSaved(double unitPrice, double qty) {
        return unitPrice * qty * discountRate;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}