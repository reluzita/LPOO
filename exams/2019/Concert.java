import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;

    private List<Act> acts;

    private int lastTicket;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.acts = new ArrayList<>();

        lastTicket = 0;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void addAct(Act act) {
        acts.add(act);
    }

    public boolean isValid(Ticket ticket) {
        return ticket.getConcert().equals(this);
    }

    public boolean participates(Artist artist) {
        for (Act act: acts) {
            if(act.equals(artist))
                return true;
            else if((act instanceof Band) && ((Band)act).containsArtist(artist)) {
                return true;
            }
        }
        return false;
    }

    public int buyTicket() {
        return ++lastTicket;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof Concert))
            return false;

        Concert c = (Concert) o;
        return date.equals(c.getDate()) && country.equals(c.getCountry()) && city.equals(c.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date);
    }
}
