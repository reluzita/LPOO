public class StringBar extends Bar {
    private boolean happyHour;
    public StringBar() {
        happyHour = false;
    }
    @Override
    boolean isHappyHour() {
        return happyHour;
    }

    @Override
    void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }

    @Override
    void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
