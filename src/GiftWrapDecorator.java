public class GiftWrapDecorator extends CartDecorator {
    private double giftWrapCost;

    public GiftWrapDecorator(ShoppingCart cart, double giftWrapCost) {
        super(cart);
        this.giftWrapCost = giftWrapCost;
    }

    @Override
    public double calculateTotal() {
        return cart.calculateTotal() + giftWrapCost;
    }
}