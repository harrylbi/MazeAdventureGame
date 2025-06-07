public class ExitRoom extends Entity {
    public ExitRoom() {
        super("Exit", 'E');
    }

    @Override
    public void interact(Player player) {
        if (player.getScore() >= 10) {
            System.out.println("🏁 Selamat! Kamu keluar dari maze dengan membawa harta karun.");
            System.exit(0);  // Mengakhiri game
        } else {
            System.out.println("🚪 Ini pintu keluar, tapi kamu belum punya harta karun!");
        }
    }
}
