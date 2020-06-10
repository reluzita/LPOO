public class ATM {
    private int id;
    private String location;
    private String code;

    public ATM(int id, String location, String code) {
        this.id = id;
        this.location = location;
        this.code = code;
    }

    public int getID() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        return id == ((ATM)o).getID() && location.equals(((ATM)o).getLocation()) && code.equals(((ATM)o).getCode());
    }
}
