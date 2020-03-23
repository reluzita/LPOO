public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuffer res = new StringBuffer(drink.getText());
        res.reverse();
        drink.setText(res.toString());
    }
}
