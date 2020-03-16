public class Application {
    public static void main(String[] args) {
        AreaAggregator areaAggregator = new AreaAggregator();
        areaAggregator.addShape(new Circle(5));
        areaAggregator.addShape(new Square(4));
        areaAggregator.addShape(new Ellipse(2, 3));


        AreaStringOutputter stringOutputter = new AreaStringOutputter(areaAggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(areaAggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
