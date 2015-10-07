package kohlspos;

/**
 *
 * @author Scott
 */
public class QtyDiscount implements DiscountStrategy {
    //right click class name > refactor > extract interface > provide name > click all boxes
    private double discountRate;
    private double minQty;
    
    public QtyDiscount(double discountRate, int minQty) {
        this.discountRate = discountRate;
        this.minQty= minQty;
    }
    
    @Override
    public final double getDiscountProductTotal(double unitPrice, double qty) {
        if(qty >= minQty) {
            return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
            }
    else {
            return unitPrice * qty;
}
        //return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    @Override
    public final double getAmountSaved(double unitPrice, double qty) {
        if(qty >= minQty){
            return unitPrice * qty * discountRate;
        } else{
            return 0;
        }
        //return unitPrice * qty * discountRate;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public final double getMinQty() {
        return minQty;
    }

    public final void setMinQty(double minQty) {
        this.minQty = minQty;
    }
}