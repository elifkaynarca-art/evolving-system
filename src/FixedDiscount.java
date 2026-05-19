public class FixedDiscount implements DiscountStrategy {
    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    // Arayüzden gelen indirim hesaplama metodunu eziyoruz (Strategy Pattern)
    @Override
    public double applyDiscount(double total) {
        // Sabit indirim tutarını toplam fiyattan düşüyoruz
        return total - amount;
    }
}