public class ShippingDecorator extends CartDecorator {
    private double shippingCost;

    // Üst sınıfın (CartDecorator) constructor'ını çağırarak sepeti sarmalıyoruz
    public ShippingDecorator(ShoppingCart cart, double shippingCost) {
        super(cart);
        this.shippingCost = shippingCost;
    }

    // Sepet hesaplamasının üzerine kargo ücretini dinamik olarak ekliyoruz (Decorator Pattern)
    @Override
    public double calculateTotal() {
        // Artık üst sınıftaki protected 'cart' nesnesinden orijinal tutarı çekip üstüne ekleme yapabiliyoruz
        return cart.calculateTotal() + shippingCost;
    }
}