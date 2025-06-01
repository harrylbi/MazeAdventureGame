public class Player extends Entity implements Moveable {
    private Room currentRoom;
    private int health;
    private int score;

    public Player(String name, char symbol, Room startRoom) {
        super(name, symbol);
        this.currentRoom = startRoom;
        this.health = 3;  // Default 3 nyawa
        this.score = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void decreaseHealth() {
        health--;
        System.out.println("❤️ Nyawamu sekarang: " + health);
    }

    public void increaseScore(int amount) {
        score += amount;
        System.out.println("💰 Skormu sekarang: " + score);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    private void moveTo(Room room) {
        if (room != null) {
            currentRoom = room;
            if (room.getEntity() != null) {
                room.getEntity().interact(this);
                room.setEntity(null);  // Entity hanya sekali digunakan
            }
        } else {
            System.out.println("❌ Tidak bisa ke arah itu.");
        }
    }

    @Override
    public void moveNorth() { moveTo(currentRoom.getNorth()); }

    @Override
    public void moveSouth() { moveTo(currentRoom.getSouth()); }

    @Override
    public void moveEast() { moveTo(currentRoom.getEast()); }

    @Override
    public void moveWest() { moveTo(currentRoom.getWest()); }

    @Override
    public void interact(Player player) {
        // Tidak ada interaksi dengan diri sendiri
    }
}
