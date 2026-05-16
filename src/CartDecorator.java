public abstract class CartDecorator {
    protected ShoppingCart cart;

    public CartDecorator(ShoppingCart cart) {
        this.cart = cart;
    }

    public abstract double calculateTotal();
}