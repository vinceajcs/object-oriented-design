package stockanalyst;

public class SegmentAnalyst extends AnalystDecorator {
    protected SegmentAnalyst(StockAnalyst sa) {
        super(sa);
    }

    public double confidenceLevel() {
        if (sa.getStockInfo().getMarketSegment().toLowerCase().equals("auto")) {
            return average(0.2, super.confidenceLevel());
        } else if (sa.getStockInfo().getMarketSegment().toLowerCase().equals("technology")) {
            return average(0.8, super.confidenceLevel());
        } else {
            return super.confidenceLevel();
        }
    }

    public String reasons() {
        if (sa.getStockInfo().getMarketSegment().toLowerCase().equals("auto")) {
            return super.reasons() + "\n\t\tAuto stocks are a bad risk.";
        } else if (sa.getStockInfo().getMarketSegment().toLowerCase().equals("technology")) {
            return super.reasons() + "\n\t\tTech stocks are a good risk.";
        } else {
            return super.reasons();
        }
    }


    private double average(double d1, double d2) {
        return (d1 + d2) / 2;
    }
}
