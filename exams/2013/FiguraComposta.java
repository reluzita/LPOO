import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiguraComposta implements Figura, Countable {
    List<Figura> figuras;

    public FiguraComposta(Figura[] figuras) {
        this.figuras = new ArrayList<>(Arrays.asList(figuras));
    }

    @Override
    public double getArea() {
        double res = 0;
        for(Figura f: figuras)
            res += f.getArea();
        return res;
    }

    @Override
    public double getPerimetro() {
        double res = 0;
        for(Figura f: figuras)
            res += f.getPerimetro();
        return res;
    }

    @Override
    public int count() {
        return figuras.size();
    }
}
