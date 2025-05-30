public class Treasure extends Entity {
    public Treasure() {
        super("Treasure", '$');
    }

    @Override
    public void interact(Player player) {
        System.out.println("🎉 Kamu menemukan harta karun!");
        // Bisa ditambah logika menyimpan poin, dll.
    }
}
