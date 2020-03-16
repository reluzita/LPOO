public class Triangle implements AreaShape {
    private int base, height;
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (height * base) / 2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
