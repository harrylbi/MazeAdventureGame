public class Player {
    private final String name;
    private final char symbol;
    private int health = 3;
    private int score = 0;
    private Room currentRoom;

    public Player(String name, char symbol, Room startRoom) {
        this.name = name;
        this.symbol = symbol;
        this.currentRoom = startRoom;
        this.currentRoom.setVisited(true);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getNeighbor(direction);
        if (nextRoom == null) {
            System.out.println("🚫 Tidak bisa ke arah itu!");
            return;
        }

        currentRoom = nextRoom;
        currentRoom.setVisited(true);

        Entity entity = currentRoom.getEntity();
        if (entity != null) {
            entity.interact(this);
            // Hanya interaksi sekali
            currentRoom.setEntity(null);
        }
    }

    public void addScore(int value) {
        score += value;
    }

    public void reduceHealth(int value) {
        health -= value;
    }
}
