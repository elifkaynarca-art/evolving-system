public class DiscountFactory {
    public static DiscountStrategy create(String type, double amount) {
        if (type.equals("PERCENTAGE")) {
            return new PercentageDiscount(amount);
        } else if (type.equals("FIXED")) {
            return new FixedDiscount(amount);
        } else {
            return new NoDiscount();
        }
    }
}