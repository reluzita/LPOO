public class Carruagem {
    private int numLugares;

    public Carruagem(int numLugares) {
        this.numLugares = numLugares;
    }


    public int getNumLugares() {
        return numLugares;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof Carruagem))
            return false;

        Carruagem c = (Carruagem) o;
        return numLugares == c.getNumLugares();
    }
}
