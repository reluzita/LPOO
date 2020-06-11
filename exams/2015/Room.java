import java.util.ArrayList;
import java.util.List;

public class Room extends Facility{
    private Building building;
    private String number;
    private int floor;
    private int capacity;

    private List<User> authorized;


    public Room(Building building, String number, int floor) throws DuplicateRoomException {
        super(building.getName() + number);
        if(floor < building.getMinFloor() || floor > building.getMaxFloor()) throw  new IllegalArgumentException();

        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = 0;
        this.authorized = new ArrayList<>();

        building.addRoom(this);
    }

    public Room(Building building, String number, int floor, int capacity) throws DuplicateRoomException {
        super(building.getName() + number);
        if(floor < building.getMinFloor() || floor > building.getMaxFloor()) throw  new IllegalArgumentException();

        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        this.authorized = new ArrayList<>();

        building.addRoom(this);
    }

    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Room(" + building.getName() + "," + number + ")";
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Room r = (Room) o;
        return building.equals(r.getBuilding())
                && number.equals(r.getNumber())
                && floor == r.getFloor()
                && capacity == r.getCapacity()
                && this.getName().equals(r.getName());
    }

    public void authorize(User user) {
        authorized.add(user);
    }

    public boolean canEnter(User user) {
        return authorized.contains(user);
    }
}
