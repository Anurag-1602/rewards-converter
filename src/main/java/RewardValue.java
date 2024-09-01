import java.math.RoundingMode;

public class RewardValue {
    private BigDecimal cashValue;
    private BigDecimal milesValue;
    private static final BigDecimal CONVERSION_RATE = BigDecimal.valueOf(0.0035).setScale(4, RoundingMode.HALF_UP);

    // Constructor that accepts a cash value
    public RewardValue(double cashValue) {
        this.cashValue = BigDecimal.valueOf(cashValue).setScale(4, RoundingMode.HALF_UP);
        this.milesValue = this.cashValue.divide(CONVERSION_RATE, RoundingMode.HALF_UP);
    }

    // Constructor that accepts a value in miles
    public RewardValue(int milesValue) {
        this.milesValue = BigDecimal.valueOf(milesValue).setScale(0, RoundingMode.HALF_UP);
        this.cashValue = this.milesValue.multiply(CONVERSION_RATE);
    }

    // Method to get the cash value of the RewardValue
    public double getCashValue() {
        return cashValue.doubleValue();
    }

    // Method to get the miles value of the RewardValue
    public double getMilesValue() {
        return milesValue.doubleValue();
    }
}
