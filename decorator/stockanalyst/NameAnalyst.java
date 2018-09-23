package stockanalyst;

public class NameAnalyst extends AnalystDecorator {
    protected NameAnalyst(StockAnalyst sa) {
        super(sa);
    }

    public double confidenceLevel() {
        String company = sa.getStockInfo().getName();
        if (company.toUpperCase().substring(0,1).equals("A")) {
            return average(1.0, super.confidenceLevel());
        } else {
            return super.confidenceLevel();
        }
    }

    public String reasons() {
        String company = sa.getStockInfo().getName();
        if (company.toUpperCase().substring(0,1).equals("A")) {
            return super.reasons() + "\n\t\tI love companies that begin with 'A'.";
        } else {
            return super.reasons();
        }
    }

    private double average(double d1, double d2) {
        return (d1 + d2) / 2;
    }
}
