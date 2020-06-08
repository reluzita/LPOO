public class Artist extends Act {
    public Artist(String name, String country) {
        super(name, country);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof Artist))
            return false;

        Artist a = (Artist) o;
        return this.getName().equals(a.getName()) && this.getCountry().equals(a.getCountry());
    }
}
