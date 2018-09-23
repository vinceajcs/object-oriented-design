package stockanalyst;

public class Bullish implements StockAnalyst {
    private StockInfo si;

    public Bullish(StockInfo si) {
        this.si = si;
    }

    public double confidenceLevel() {
        return 0.7;
    }

    public String reasons() {
        return "I think the market is going up.";
    }

    public StockInfo getStockInfo() {
        return si;
    }
}
