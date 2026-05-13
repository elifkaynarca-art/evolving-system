import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();
    private String discountType = "NONE";
    private double discountAmount = 0;

    public void addItem(Product p) {
        items.add(p);
    }

    public void setDiscount(String type, double amount) {
        this.discountType = type;
        this.discountAmount = amount;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total = total + p.getPrice();
        }

        if (discountType.equals("PERCENTAGE")) {
            total = total - (total * discountAmount / 100);
        } else if (discountType.equals("FIXED")) {
            total = total - discountAmount;
        }

        return total;
    }
}