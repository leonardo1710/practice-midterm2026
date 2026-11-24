package at.ac.hcw;

import java.util.Locale;

public class Trader {
    private final String name;
    private final boolean isBuyer;
    private double priceLimit;
    private int tradesDone;
    private double totalProfit;

    // constructor
    public Trader(String name, boolean isBuyer, double priceLimit) {
        this.name = name;
        this.isBuyer = isBuyer;
        this.priceLimit = priceLimit;
        this.tradesDone = 0;
        this.totalProfit = 0.0;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public String getName() {
        return name;
    }

    public int getTradesDone() {
        return tradesDone;
    }

    public double getPriceLimit() {
        return priceLimit;
    }

    public boolean isBuyer() {
        return isBuyer;
    }

    public void adjustPriceLimit(double delta) {
        priceLimit += delta;

        if (priceLimit < 0) {
            priceLimit = 0;
        }

        // or even shorter:
        // priceLimit = Math.max(0.0, priceLimit + delta); // Math.max returns the greater value of both arguments
    }

    public void recordTrade(double achievedPrice) {
        if (isBuyer) {
            totalProfit += priceLimit - achievedPrice;
        } else {
            totalProfit += achievedPrice - priceLimit;
        }

        tradesDone++;
    }

    @Override
    public String toString() {
        String type = isBuyer ? "Käufer*in" : "Verkäufer*in";
        return String.format(
                Locale.US,
                "#%s (%s): Preislimit=%.2f | Trades=%d | Gewinn=%.2f",
                name,
                type,
                priceLimit,
                tradesDone,
                totalProfit
        );
    }
}
