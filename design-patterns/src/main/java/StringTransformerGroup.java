import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> transformers;
    public StringTransformerGroup(List<StringTransformer> t) {
        transformers = t;
    }

    @Override
    public void execute(StringDrink drink) {
        for(StringTransformer t: transformers) {
            t.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        for(StringTransformer t: transformers) {
            t.undo(drink);
        }
    }
}
