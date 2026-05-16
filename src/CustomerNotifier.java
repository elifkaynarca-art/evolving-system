public class CustomerNotifier implements PriceObserver {
    public void onPriceChanged(String productName, double newPrice) {
        System.out.println("Fiyat degisti: " + productName + " -> " + newPrice + " TL");
    }
}