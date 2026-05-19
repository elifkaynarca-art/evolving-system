public interface PriceObserver {
    // Fiyat güncellendiğinde tetiklenecek ortak metot imzası
    void update(ObservableProduct product);
}