public class CustomerNotifier implements PriceObserver {
    
    // PriceObserver arayüzünden gelen metodu zorunlu olarak eziyoruz (Override)
    @Override
    public void update(ObservableProduct product) {
        // Gelen nesne aslında bir Product olduğu için onu güvenli bir şekilde cast ediyoruz
        if (product instanceof Product) {
            Product p = (Product) product;
            
            // Ürünün içinden ihtiyacımız olan güncel verileri kendimiz çekiyoruz (Pull Model)
            String productName = p.getName();
            double newPrice = p.getPrice();
            
            // Bildirimi ekrana basıyoruz
            System.out.println("Fiyat degisti: " + productName + " -> " + newPrice + " TL");
        }
    }
}