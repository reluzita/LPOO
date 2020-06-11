public abstract class Facility {
    String name;

    public Facility(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getCapacity();

    public abstract boolean canEnter(User user);
}
