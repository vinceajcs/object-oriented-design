package stockanaylst;

public abstract class AnalystDecorator implements StockAnalyst {
    protected StockAnalyst sa;

    protected AnalystDecorator(StockAnalyst sa) {
        this.sa = sa;
    }

    public double confidenceLevel() {
        return sa.confidenceLevel();
    }

    public String reasons() {
        return sa.reasons();
    }

    public StockInfo getStockInfo() {
        return sa.getStockInfo();
    }
}
