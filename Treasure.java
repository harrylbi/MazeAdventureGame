public class Treasure extends Entity {
    private int value;

    public Treasure() {
        super("Treasure", '$');
        this.value = 10;  // Default nilai treasure
    }

    @Override
    public void interact(Player player) {
        System.out.println("🎉 Kamu menemukan harta karun! +10 poin.");
        player.increaseScore(value);
    }
}
