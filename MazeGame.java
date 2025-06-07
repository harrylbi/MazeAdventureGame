import java.util.Scanner;

public class MazeGame {
    private Player player;

    public void startGame() {
        Room[][] rooms = new Room[3][3];

        // Inisialisasi semua ruangan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rooms[i][j] = new Room("Ruangan kosong.");
            }
        }

        // Set deskripsi (bisa juga diubah lewat entity)
        rooms[0][0].setDescription("Ruangan jebakan! ⚠️");
        rooms[0][2].setDescription("Kamu menemukan harta karun! 💰");
        rooms[1][1].setDescription("Kamu berada di ruangan awal.");
        rooms[1][2].setDescription("Ruangan jebakan! ⚠️");
        rooms[2][2].setDescription("Ini ruangan keluar! 🚪");

        // Tambahkan entitas
        rooms[0][0].setEntity(new Trap());
        rooms[1][2].setEntity(new Trap());
        rooms[0][2].setEntity(new Treasure());
        rooms[2][2].setEntity(new ExitRoom());

        // Tetapkan koneksi antar ruangan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i > 0) rooms[i][j].setNeighbor("north", rooms[i - 1][j]);
                if (i < 2) rooms[i][j].setNeighbor("south", rooms[i + 1][j]);
                if (j > 0) rooms[i][j].setNeighbor("west", rooms[i][j - 1]);
                if (j < 2) rooms[i][j].setNeighbor("east", rooms[i][j + 1]);
            }
        }

        player = new Player("Petualang", '@', rooms[1][1]);

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
