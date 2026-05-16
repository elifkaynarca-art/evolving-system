import java.util.ArrayList;
import java.util.List;

public class ObservableProduct {
    private String name;
    private double price;
    private List<PriceObserver> observers = new ArrayList<>();

    public ObservableProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addObserver(PriceObserver observer) {
        observers.add(observer);
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        for (PriceObserver o : observers) {
            o.onPriceChanged(name, newPrice);
        }
    }

    public double getPrice() { return price; }
    public String getName() { return name; }
}