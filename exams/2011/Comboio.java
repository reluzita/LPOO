import java.util.ArrayList;
import java.util.List;

public class Comboio {
    private String nome;
    private List<Carruagem> carruagens;
    int passageiros;
    ServicoABordo servicoABordo;

    public Comboio(String nome) {
        this.nome = nome;
        this.carruagens = new ArrayList<>();
        this.passageiros = 0;
        this.servicoABordo = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public int getNumCarruagens() {
        return carruagens.size();
    }

    public int getNumLugares() {
        int res = 0;
        for (Carruagem c: carruagens)
            res += c.getNumLugares();
        return res;
    }

    public void addCarruagem(Carruagem c) {
        carruagens.add(c);
    }

    public Carruagem getCarruagemByOrder(int index) {
        return carruagens.get(index);
    }

    public void removeAllCarruagens(int capacity) {
        carruagens.removeIf(c -> c.getNumLugares() == capacity);
    }

    public int getNumPassageiros() {
        return passageiros;
    }

    public int getLugaresLivres() {
        return getNumLugares() - passageiros;
    }

    public void addPassageiros(int num) throws PassengerCapacityExceeded{
        if(num > getLugaresLivres())
            throw new PassengerCapacityExceeded();
        passageiros += num;
    }

    public void removePassageiros(int num){
        passageiros -= num;
    }

    public void removePassageiros(){
        passageiros = 0;
    }

    @Override
    public String toString() {
        String res = "Comboio " + nome + ", " + getNumCarruagens();
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

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof Comboio))
            return false;

        Comboio c = (Comboio) o;

        if(this.getNumCarruagens() != c.getNumCarruagens())
            return false;

        for(int i = 0; i < getNumCarruagens(); i++) {
            if(!this.getCarruagemByOrder(i).equals(c.getCarruagemByOrder(i)))
                return false;
        }
        return true;
    }

    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public String getDescricaoServico() {
        return servicoABordo.getDescricao();
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }
}
