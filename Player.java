public class Player extends Entity implements Moveable {
    private Room currentRoom;

    public Player(String name, char symbol, Room startRoom) {
        super(name, symbol);
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    private void moveTo(Room room) {
        if (room != null) {
            currentRoom = room;
            if (room.getEntity() != null) {
                room.getEntity().interact(this);
            }
        } else {
            System.out.println("Tidak bisa ke arah itu.");
        }
    }

    @Override
    public void moveNorth() {
        moveTo(currentRoom.getNorth());
    }

    @Override
    public void moveSouth() {
        moveTo(currentRoom.getSouth());
    }

    @Override
    public void moveEast() {
        moveTo(currentRoom.getEast());
    }

    @Override
    public void moveWest() {
        moveTo(currentRoom.getWest());
    }

    @Override
    public void interact(Player player) {
        // Player tidak berinteraksi dengan dirinya sendiri
    }
}
