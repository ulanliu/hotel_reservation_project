package model;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }

    @Override
    public String toString() {
        return "This room is for free!" + super.toString();
    }
}
