package model;

public class RoomDriver {
    public static void main(String[] args) {
        Room room = new Room("301", 3000.0, RoomType.DOUBLE);

        System.out.println(room);
    }
}
