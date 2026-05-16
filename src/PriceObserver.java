public interface PriceObserver {
    void onPriceChanged(String productName, double newPrice);
}