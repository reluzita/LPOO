import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public static List<Ticket> buy(Concert concert, int n) throws InvalidTicket {
        List<Ticket> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            res.add(new Ticket(concert.buyTicket(), concert));
        }

        return res;
    }
}
