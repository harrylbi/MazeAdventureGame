public class Treasure extends Entity {
    private int value;

    public Treasure() {
        super("Treasure", '$');
        this.value = 10;
    }

    public void interact(Player player) {
        if (isActive()) {
            System.out.println("🎉 Kamu menemukan harta karun! +10 poin.");
            player.increaseScore(10);
            deactivate();
        } else {
            System.out.println("📍 Ini bekas tempat harta karun.");
        }
    }
}
