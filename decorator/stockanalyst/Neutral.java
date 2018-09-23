package stockanalyst;

public class Neutral implements StockAnalyst {
    private StockInfo si;

    public Neutral(StockInfo si) {
        this.si = si;
    }

    public double confidenceLevel() {
        return 0.5;
    }

    public String reasons() {
        return "The market's future is unclear.";
    }

    public StockInfo getStockInfo() {
        return si;
    }
}
