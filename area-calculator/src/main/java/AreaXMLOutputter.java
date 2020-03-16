public class AreaXMLOutputter {
    private SumProvider areaAggregator;
    public AreaXMLOutputter(SumProvider areaAggregator) {
        this.areaAggregator = areaAggregator;
    }

    public String output() {
        return "<area>" + this.areaAggregator.sum() + "</area>";
    }
}
