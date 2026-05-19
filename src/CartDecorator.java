// Decorator'ın ShoppingCart gibi davranabilmesi için ondan türemesi gerekir
public abstract class CartDecorator extends ShoppingCart {
    // Alt sınıfların erişebilmesi için protected yapıyoruz
    protected ShoppingCart cart;

    // Sarmalama (Composition) işlemini kuran constructor
    public CartDecorator(ShoppingCart cart) {
        this.cart = cart;
    }

    // Üst sınıftaki metodu override edip işi sarmalanan nesneye devrediyoruz
    @Override
    public double calculateTotal() {
        return cart.calculateTotal();
    }
}