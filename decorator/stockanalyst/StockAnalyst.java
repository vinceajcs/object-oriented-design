package stockanalyst;

public interface StockAnalyst {
    double confidenceLevel();
    String reasons();
    StockInfo getStockInfo();
}
