public class AreaStringOutputter {
    private SumProvider areaAggregator;
    public AreaStringOutputter(SumProvider areaAggregator) {
        this.areaAggregator = areaAggregator;
    }
    public String output() {
        return "Sum of areas: " + this.areaAggregator.sum();
    }
}
