public class Trap extends Entity {
    public Trap() {
        super("Trap", 'X');
    }

    @Override
    public void interact(Player player) {
        System.out.println("⚠️ Kamu terkena jebakan!");
        // Bisa ditambah logika mengurangi HP, dll.
    }
}
