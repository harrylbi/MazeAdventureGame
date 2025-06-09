import java.util.Scanner;

public class MazeGame {
    private Player player;

    private void renderMazeVisual(Room[][] rooms) {
        System.out.println();
        for (int i = 0; i < rooms.length; i++) {
            // Garis atas tiap baris
            System.out.print("+");
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print("---+");
            }
            System.out.println();

            // Isi ruangan
            System.out.print("|");
            for (int j = 0; j < rooms[i].length; j++) {
                Room room = rooms[i][j];
                if (room == player.getCurrentRoom()) {
                    System.out.print(" @ |");
                } else if (room.isVisited()) {
                    System.out.print(" . |");
                } else {
                    System.out.print(" ? |");
                }
            }
            System.out.println();
        }

        // Garis bawah terakhir
        System.out.print("+");
        for (int j = 0; j < rooms[0].length; j++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    public void startGame() {
        Room[][] rooms = new Room[3][3];

        // Inisialisasi ruangan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rooms[i][j] = new Room("Ruangan kosong.");
            }
        }

        // Set deskripsi khusus
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

        // Hubungkan antar ruangan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i > 0) rooms[i][j].setNeighbor("north", rooms[i - 1][j]);
                if (i < 2) rooms[i][j].setNeighbor("south", rooms[i + 1][j]);
                if (j > 0) rooms[i][j].setNeighbor("west", rooms[i][j - 1]);
                if (j < 2) rooms[i][j].setNeighbor("east", rooms[i][j + 1]);
            }
        }

        player = new Player("Petualang", '@', rooms[1][1]);
        player.getCurrentRoom().setVisited(true); // tandai awal sebagai sudah dikunjungi

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("🧭 Selamat datang di Maze Adventure!");
        while (true) {
            System.out.println("\n📍 Lokasi: " + player.getCurrentRoom().getDescription());
            System.out.println("❤️ Nyawa: " + player.getHealth() + " | 💰 Skor: " + player.getScore());
            renderMazeVisual(rooms); // Tampilkan peta

            System.out.print("➡️ Arahkan (north/south/east/west/exit): ");
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "north" -> player.move("north");
                case "south" -> player.move("south");
                case "east"  -> player.move("east");
                case "west"  -> player.move("west");
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
