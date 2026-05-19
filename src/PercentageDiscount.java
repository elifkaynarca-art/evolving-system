public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    // Arayüzden gelen indirim hesaplama metodunu eziyoruz (Strategy Pattern)
    @Override
    public double applyDiscount(double total) {
        // Yüzdelik indirim oranını uygulayıp net tutarı dönüyoruz
        return total - (total * percentage / 100);
    }
}