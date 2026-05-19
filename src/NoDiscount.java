public class NoDiscount implements DiscountStrategy {
    
    // Herhangi bir indirim uygulanmadığı durumlar için fiyatı aynen geri dönüyoruz (Null Object Pattern)
    @Override
    public double applyDiscount(double total) {
        return total;
    }
}