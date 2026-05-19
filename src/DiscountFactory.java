public class DiscountFactory {
    
    // Nesne yaratım sorumluluğunu merkezi hale getiren fabrika metodu (Factory Method)
    public static DiscountStrategy create(String type, double amount) {
        // NullPointerException hatasını engellemek için güvenli String karşılaştırması yapıyoruz
        if ("PERCENTAGE".equalsIgnoreCase(type)) {
            return new PercentageDiscount(amount);
        } else if ("FIXED".equalsIgnoreCase(type)) {
            return new FixedDiscount(amount);
        } else {
            // Bilinmeyen veya boş indirim durumlarında güvenli bir varsayılan nesne dönüyoruz (Null Object Pattern)
            return new NoDiscount();
        }
    }
}