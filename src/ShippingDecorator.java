public class ShippingDecorator extends CartDecorator {
    private double shippingCost;

    public ShippingDecorator(ShoppingCart cart, double shippingCost) {
        super(cart);
        this.shippingCost = shippingCost;
    }

    public double calculateTotal() {
        return cart.calculateTotal() + shippingCost;
    }
}