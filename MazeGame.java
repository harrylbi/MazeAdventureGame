import java.util.Scanner;

public class MazeGame {
    private Player player;

    public void startGame() {
        // Setup rooms
        Room start = new Room("Kamu berada di ruangan awal.");
        Room north = new Room("Ruangan utara yang gelap.");
        Room east = new Room("Ruangan timur yang terang.");

        // Tetapkan hubungan antar ruangan
        start.setNeighbor("north", north);
        start.setNeighbor("east", east);
        north.setNeighbor("south", start);
        east.setNeighbor("west", start);

        // Tambahkan entitas
        north.setEntity(new Trap());
        east.setEntity(new Treasure());

        // Inisialisasi player
        player = new Player("Petualang", '@', start);

        // Game loop
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Selamat datang di Maze Adventure!");
        while (true) {
            System.out.println("\n📍 Lokasi: " + player.getCurrentRoom().getDescription());
            System.out.print("Arahkan (north/south/east/west/exit): ");
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "north" -> player.moveNorth();
                case "south" -> player.moveSouth();
                case "east"  -> player.moveEast();
                case "west"  -> player.moveWest();
                case "exit"  -> {
                    System.out.println("Game selesai.");
                    return;
                }
                default -> System.out.println("Perintah tidak dikenali.");
            }
        }
    }

    public static void main(String[] args) {
        new MazeGame().startGame();
    }
}
