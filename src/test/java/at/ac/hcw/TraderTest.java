package at.ac.hcw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TraderTest {
    @Test
    void exposesInitialState() {
        Trader buyer = new Trader("Buyer1", true, 12.5);

        assertEquals("Buyer1", buyer.getName());
        assertTrue(buyer.isBuyer());
        assertEquals(12.5, buyer.getPriceLimit());
        assertEquals(0, buyer.getTradesDone());
        assertEquals(0.0, buyer.getTotalProfit());
    }

    @Test
    void priceLimitCannotFallBelowZero() {
        Trader seller = new Trader("Seller1", false, 0.25);

        seller.adjustPriceLimit(-1.0);

        assertEquals(0.0, seller.getPriceLimit());
    }

    @Test
    void calculatesProfitAccordingToTraderRole() {
        Trader buyer = new Trader("Buyer1", true, 15.0);
        Trader seller = new Trader("Seller1", false, 9.0);

        buyer.recordTrade(12.0);
        seller.recordTrade(12.0);

        assertEquals(3.0, buyer.getTotalProfit());
        assertEquals(3.0, seller.getTotalProfit());
        assertEquals(1, buyer.getTradesDone());
        assertEquals(1, seller.getTradesDone());
        assertFalse(seller.isBuyer());
    }

    @Test
    void formatsStatisticsWithTwoDecimalPlaces() {
        Trader seller = new Trader("Seller1", false, 11.71);
        seller.recordTrade(15.69);

        assertEquals(
                "#Seller1 (Verkäufer*in): Preislimit=11.71 | Trades=1 | Gewinn=3.98",
                seller.toString()
        );
    }
}
