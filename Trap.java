public class Trap extends Entity {
    public Trap() {
        super("Trap", 'X');
    }

    
    @Override
    public void interact(Player player) {
        if (isActive()) {
            System.out.println("⚠️ Kamu terkena jebakan! Nyawamu berkurang.");
            player.decreaseHealth();
            deactivate();
        } else {
            System.out.println("📍 Ini bekas jebakan. Tidak terjadi apa-apa.");
        }
    }
}
