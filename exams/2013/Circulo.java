public class Circulo implements Figura{
    private Ponto centro;
    private int raio;


    public Circulo(Ponto centro, int raio) {
        if(raio < 0)
            throw new IllegalArgumentException();
        this.centro = centro;
        this.raio = raio;
    }


    public Ponto getCentro() {
        return centro;
    }

    public int getRaio() {
        return raio;
    }

    public double getArea() {
        return Math.PI*raio*raio;
    }

    @Override
    public double getPerimetro() {
        return 2*Math.PI*raio;
    }
}
