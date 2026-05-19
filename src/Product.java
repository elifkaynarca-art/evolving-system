// Ürünün fiyat değişimlerini yayınlayabilmesi için ObservableProduct'ı genişletmesi (kalıtım alması) gerekir
public class Product extends ObservableProduct {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { 
        return name; 
    }
    
    public double getPrice() { 
        return price; 
    }

    // Fiyat değiştiğinde kayıtlı gözlemcileri (observer) haberdar eden kritik metot
    public void setPrice(double newPrice) {
        this.price = newPrice;
        // Fiyat güncellendiği an tüm dinleyicilere haber veriyoruz (Observer Pattern)
        // Parametre olarak kendimizi (this) göndererek 'Pull Model' uyguluyoruz
        notifyObservers();
    }
}