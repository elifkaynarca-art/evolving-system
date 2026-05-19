public interface DiscountStrategy {
    // Farklı indirim algoritmalarının uyması gereken ortak sözleşme (Strategy Pattern)
    double applyDiscount(double total);
}