import java.util.HashMap;

public abstract class ProbabilityDistribution {
    private double mean;
    private double stddev;

    private static HashMap<String, ProbabilityDistribution> distributions = new HashMap<>();

    public ProbabilityDistribution() {
        this.mean = 0.0;
        this.stddev = 1.0;
    }

    public ProbabilityDistribution(double mean, double stddev) {
        if(stddev <= 0) throw new IllegalArgumentException();

        this.mean = mean;
        this.stddev = stddev;
    }

    public ProbabilityDistribution(String name, double mean, double stddev) {
        this.mean = mean;
        this.stddev = stddev;
        distributions.put(name, this);
    }

    public double getMean() {
        return mean;
    }

    public double getStddev() {
        return stddev;
    }

    public abstract double probabilityDensityFunction(double x);

    public abstract double calcRangeProbability(double x1, double x2);

    public abstract double calcLeftProbability(double x);

    public static ProbabilityDistribution find(String name) {
        return distributions.get(name);
    }
}
