import static java.lang.String.format;

public abstract class Transaction {
    private ATM atm;
    private Session session;
    private Card card;
    private int id;
    private double amount;

    public Transaction(ATM atm, Session session, Card card, int id) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.id = id;
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        if(this instanceof Withdrawal)
            return "Withdrawal " + "at ATM " + atm.getID() + " (" + atm.getLocation() + ", " + atm.getCode() + ") of " + format("%.2f", amount);

        if(this instanceof Deposit)
            return "Deposit " + "at ATM " + atm.getID() + " (" + atm.getLocation() + ", " + atm.getCode() + ") of " + amount;

        return "";
    }
}
