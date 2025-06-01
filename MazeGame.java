import java.util.Scanner;

public class MazeGame {
    private Player player;

    public void startGame() {
        Room start = new Room("Kamu berada di ruangan awal.");
        Room north = new Room("Ruangan utara yang gelap.");
        Room east = new Room("Ruangan timur yang terang.");
        Room west = new Room("Ruangan barat yang misterius.");

        start.setNeighbor("north", north);
        start.setNeighbor("east", east);
        start.setNeighbor("west", west);
        north.setNeighbor("south", start);
        east.setNeighbor("west", start);
        west.setNeighbor("east", start);

        north.setEntity(new Trap());
        east.setEntity(new Treasure());
        west.setEntity(new Trap());

        player = new Player("Petualang", '@', start);

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("🧭 Selamat datang di Maze Adventure!");
        while (true) {
            System.out.println("\n📍 Lokasi: " + player.getCurrentRoom().getDescription());
            System.out.println("❤️ Nyawa: " + player.getHealth() + " | 💰 Skor: " + player.getScore());
            System.out.print("➡️ Arahkan (north/south/east/west/exit): ");
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "north" -> player.moveNorth();
                case "south" -> player.moveSouth();
                case "east"  -> player.moveEast();
                case "west"  -> player.moveWest();
                case "exit"  -> {
                    System.out.println("🚪 Game selesai.");
                    return;
                }
                default -> System.out.println("❓ Perintah tidak dikenali.");
            }

            if (player.getHealth() <= 0) {
                System.out.println("\n💀 Kamu mati karena kehabisan nyawa. Game over!");
                break;
            }
        }

        System.out.println("🏁 Skor akhir: " + player.getScore());
    }

    public static void main(String[] args) {
        new MazeGame().startGame();
    }
}
