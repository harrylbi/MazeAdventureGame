public class Player extends Entity implements Moveable {
    private Room currentRoom;
    private int health;
    private int score;

    public Player(String name, char symbol, Room startRoom) {
        super(name, symbol);
        this.currentRoom = startRoom;
        this.health = 3;
        this.score = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void decreaseHealth() {
        if (health > 0) {
            health--;
            System.out.println("❤️ Nyawamu sekarang: " + health);
            if (health == 0) {
                System.out.println("💀 Kamu kehabisan nyawa! Game Over.");
                // Bisa tambah logika keluar game atau restart di sini
            }
        }
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
            Entity entity = room.getEntity();
            if (entity != null && entity.isActive()) {
                entity.interact(this);
                entity.deactivate();  // Entity hanya aktif sekali
                room.setEntity(null); // Jika mau supaya entity hilang setelah interaksi
            }
        } else {
            System.out.println("❌ Tidak bisa ke arah itu.");
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
