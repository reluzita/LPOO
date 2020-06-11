import java.util.ArrayList;
import java.util.List;

public class Building extends Facility{
    private int minFloor;
    private int maxFloor;
    private List<Room> rooms;

    public Building(String name, int minFloor, int maxFloor) {
        super(name);
        if(minFloor > maxFloor) throw new IllegalArgumentException();

        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.rooms = new ArrayList<>();
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    @Override
    public String toString() {
        return "Building(" + getName() + ")";
    }

    @Override
    public int getCapacity() {
        int res = 0;
        for(Room room: rooms)
            res += room.getCapacity();
        return res;
    }

    public void addRoom(Room room) throws DuplicateRoomException{
        if(rooms.contains(room))
            throw new DuplicateRoomException();
        rooms.add(room);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Building b = (Building) o;
        return minFloor == b.getMinFloor()
                && maxFloor == b.getMaxFloor()
                && this.getName().equals(b.getName());
    }

    public boolean canEnter(User user) {
        for(Room room : rooms) {
            if (room.canEnter(user))
                return true;
        }
        return false;
    }
}
