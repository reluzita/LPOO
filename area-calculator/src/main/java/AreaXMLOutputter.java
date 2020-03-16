public class AreaXMLOutputter {
    private AreaAggregator areaAggregator;
    public AreaXMLOutputter(AreaAggregator areaAggregator) {
        this.areaAggregator = areaAggregator;
    }

    public String output() {
        return "<area>" + this.areaAggregator.sum() + "</area>";
    }
}
