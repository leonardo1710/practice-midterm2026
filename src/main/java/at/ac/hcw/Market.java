package at.ac.hcw;

import java.util.Locale;


public class Market {
    private static final double MIN_BUYER_PRICE = 10.0;
    private static final double MAX_BUYER_PRICE = 15.0;
    private static final double MIN_SELLER_PRICE = 8.0;
    private static final double MAX_SELLER_PRICE = 13.0;

    private final Trader[] buyers;
    private final Trader[] sellers;
    private int rounds;

    // constructor
    public Market(int size) {
        buyers = new Trader[size];
        sellers = new Trader[size];
        rounds = 0;

        for (int i = 0; i < size; i++) {
            buyers[i] = new Trader(
                    "Buyer" + i,
                    true,
                    MIN_BUYER_PRICE + Math.random() * (MAX_BUYER_PRICE - MIN_BUYER_PRICE) // e.g 10.0 + Math.random() * (15.0 - 10.0)
            );
            sellers[i] = new Trader(
                    "Seller" + i,
                    false,
                    MIN_SELLER_PRICE + Math.random() * (MAX_SELLER_PRICE - MIN_SELLER_PRICE)
            );
        }
    }

    public void runRound() {
        System.out.printf("%n-- Handelsrunde %d --%n", rounds + 1);

        for (int i = 0; i < buyers.length; i++) {
            Trader buyer = buyers[i];
            Trader seller = sellers[i];

            if (buyer.getPriceLimit() >= seller.getPriceLimit()) { // bid > ask
                double tradePrice = (buyer.getPriceLimit() + seller.getPriceLimit()) / 2.0; //avg between trader and buyer
                buyer.recordTrade(tradePrice);
                seller.recordTrade(tradePrice);
                buyer.adjustPriceLimit(-0.2);
                seller.adjustPriceLimit(0.2);

                System.out.printf(
                        Locale.US,
                        "%s erwirbt von %s zum Preis von %.2f%n",
                        buyer.getName(),
                        seller.getName(),
                        tradePrice
                );
            } else {
                buyer.adjustPriceLimit(0.1);
                seller.adjustPriceLimit(-0.1);
                System.out.printf(
                        Locale.US,
                        "Zwischen %s (%.2f) und %s (%.2f) ist kein Handel zustande gekommen!%n",
                        buyer.getName(),
                        buyer.getPriceLimit(),
                        seller.getName(),
                        seller.getPriceLimit()
                );
            }
        }

        rounds++;
    }

    public void showStatistics() {
        System.out.printf("%n-- Handelsrunden --%n%d%n", rounds);
        System.out.println("--- Käufer*innen ---");
        for (Trader buyer : buyers) {
            System.out.println(buyer);
        }

        System.out.println("--- Verkäufer*innen ---");
        for (Trader seller : sellers) {
            System.out.println(seller);
        }
    }
}
