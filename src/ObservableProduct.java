import java.util.ArrayList;
import java.util.List;

public class ObservableProduct {
    // Ürünü dinleyen gözlemcilerin listesi
    private List<PriceObserver> observers = new ArrayList<>();

    // Parametresiz constructor'ı açıkça tanımlayarak Product'taki hatayı çözüyoruz
    public ObservableProduct() {
    }

    // Yeni bir dinleyici (observer) kaydetme metodu
    public void attach(PriceObserver observer) {
        observers.add(observer);
    }

    // Dinleyiciyi listeden çıkarma metodu
    public void detach(PriceObserver observer) {
        observers.remove(observer);
    }

    // Fiyat değiştiğinde tüm dinleyicileri tetikleyen metot
    public void notifyObservers() {
        for (PriceObserver observer : observers) {
            // Dinleyicilere güncellenen nesnenin referansını paslıyoruz (Pull Model)
            observer.update(this);
        }
    }
}