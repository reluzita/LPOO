public class NormalDistribution extends ProbabilityDistribution {
    public NormalDistribution() {
        super();
    }

    public NormalDistribution(double mean, double stddev) {
        super(mean, stddev);
    }

    public NormalDistribution(String name, double mean, double stddev) {
        super(name, mean, stddev);
    }


    @Override
    public double probabilityDensityFunction(double x) {
        return (1/(getStddev() * Math.sqrt(2*Math.PI)))*Math.exp(-(0.5)*((x-getMean())/getStddev())*((x-getMean())/getStddev()));
    }

    public double calcRangeProbability(double x1, double x2) {
        return Math.abs(x1 - x2) / 2 * 0.477250;
    }

    @Override
    public double calcLeftProbability(double x) {
        if (x < 1)
            return 0.5 - 0.477250;
        else if (x > 1)
            return 0.5 + 0.477250;
        return 0.5;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        NormalDistribution nd = (NormalDistribution) o;
        return this.getMean() == nd.getMean() && this.getStddev() == nd.getStddev();
    }

    @Override
    public String toString() {
        return "N(" + getMean() + ", " + getStddev() + ")";
    }

}
