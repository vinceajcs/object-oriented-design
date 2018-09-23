package stockanalyst;

public class Bearish implements StockAnalyst {
    private StockInfo si;

    public Bearish(StockInfo si) {
        this.si = si;
    }

    public double confidenceLevel() {
        return 0.3;
    }

    public String reasons() {
        return "I think the market is going down.";
    }

    public StockInfo getStockInfo() {
        return si;
    }
}
