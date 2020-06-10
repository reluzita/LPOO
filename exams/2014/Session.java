import java.util.ArrayList;
import java.util.List;

public class Session implements Countable{
    private ATM atm;
    private List<Transaction> transactions;

    public Session(ATM atm) {
        this.atm = atm;

        transactions = new ArrayList<>();
    }

    public ATM getATM() {
        return atm;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public int count() {
        return transactions.size();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Session s = (Session) o;
        return atm.equals(s.getATM());
    }
}
