public class Pendular extends Comboio {
    public Pendular(String nome) {
        super(nome);
        setServicoABordo(new ServicoSemEnjoos());
    }

    @Override
    public String toString() {
        String res = "Pendular " + getNome() + ", " + getNumCarruagens();
        if(getNumCarruagens() == 1)
            res += " carruagem, " + getNumLugares();
        else
            res += " carruagens, " + getNumLugares();

        if(getNumLugares() == 1)
            res += " lugar, " + getNumPassageiros();
        else
            res += " lugares, " + getNumPassageiros();

        if(getNumPassageiros() == 1)
            res += " passageiro";
        else
            res += " passageiros";

        return res;
    }
}
