import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private DiscountStrategy discountStrategy = new NoDiscount();

    public void addItem(Product p) {
        items.add(p);
    }

    public void setDiscount(String type, double amount) {
        this.discountStrategy = DiscountFactory.create(type, amount);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total = total + p.getPrice();
        }
        return discountStrategy.applyDiscount(total);
    }
}