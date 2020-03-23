import static java.lang.Character.*;

public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < drink.getText().length(); i++) {
            char c = drink.getText().charAt(i);
            if(isUpperCase(c))
                c = toLowerCase(c);
            else
                c = toUpperCase(c);
            res.append(c);
        }
        drink.setText(res.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        this.execute(drink);
    }
}
