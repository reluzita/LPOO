public class Ponto implements Comparable{
    private int x;
    private int y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Ponto p = (Ponto) o;
        return x == p.getX() && y == p.getY();
    }

    @Override
    public int compareTo(Object o) {
        Ponto p = (Ponto) o;
        if(x > p.getX()) return 1;
        else if(x == p.getX()) {
            return Integer.compare(y, p.getY());
        }
        else return -1;
    }
}
