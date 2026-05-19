import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private DiscountStrategy discountStrategy = new NoDiscount();

    // Sepete ürün ekleme metodu
    public void addItem(Product p) {
        items.add(p);
    }

    // İndirim stratejisini dışarıdan enjekte eden metot (Strategy Pattern)
    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    // Fiyatı hesaplayan ve if-else barındırmayan metot (OCP uyumlu)
    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total = total + p.getPrice();
        }
        return discountStrategy.applyDiscount(total);
    }
}