public class StringReplacer implements StringTransformer {
    private char a, b;
    public StringReplacer(char a, char b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void execute(StringDrink drink) {
        String newstr = drink.getText().replace(a, b);
        drink.setText(newstr);
    }

    @Override
    public void undo(StringDrink drink) {
        String newstr = drink.getText().replace(b, a);
        drink.setText(newstr);
    }
}
