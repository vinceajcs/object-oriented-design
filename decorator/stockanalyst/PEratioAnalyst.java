package stockanalyst;

public class PEratioAnalyst extends AnalystDecorator {
    protected PEratioAnalyst(StockAnalyst sa) {
        super(sa);
    }

    public double confidenceLevel() {
        return average(1 - (calculateRatio() / 24), super.confidenceLevel());
    }

    private double calculateRatio() {
        double price = sa.getStockInfo().getSharePrice();
        double earnings = sa.getStockInfo().getEarnings();
        return price / earnings;
    }

    public String reasons() {
        if (calculateRatio() == 12) {
            return super.reasons() + "\n\t\tThe PE ratio is " + calculateRatio() + ", which is average.";
        } else if (calculateRatio() > 12) {
            return super.reasons() + "\n\t\tThe PE ratio is " + calculateRatio() + ", which is bad.";
        } else {
            return super.reasons() + "\n\t\tThe PE ratio is " + calculateRatio() + ", which is good!";
        }
    }

    private double average(double d1, double d2) {
        return (d1 + d2) / 2;
    }

}
