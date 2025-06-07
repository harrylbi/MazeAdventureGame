import java.util.HashMap;
import java.util.Map;

public class Room {
    private String description;
    private Entity entity;
    private Map<String, Room> neighbors;

    public Room(String description) {
        this.description = description;
        this.neighbors = new HashMap<>();
    }

    public void setDescription(String description) {
        this.description = description;
    }

public String getDescription() {
    if (entity instanceof Trap) {
        if (entity.isActive()) {
            return "📍 Lokasi: Ruangan jebakan! ⚠️";
        } else {
            return "📍 Lokasi: Ruangan kosong bekas jebakan.";
        }
    } else if (entity instanceof Treasure) {
        if (entity.isActive()) {
            return "📍 Lokasi: Kamu menemukan harta karun! 💰";
        } else {
            return "📍 Lokasi: Ruangan kosong bekas harta karun.";
        }
    } else if (entity instanceof ExitRoom) {
        return "📍 Lokasi: Ini ruangan keluar! 🚪";
    } else {
        return "📍 Lokasi: Ruangan kosong.";
    }
}



    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setNeighbor(String direction, Room room) {
        neighbors.put(direction, room);
    }

    public Room getNeighbor(String direction) {
        return neighbors.get(direction);
    }

    public Room getNorth() { return neighbors.get("north"); }
    public Room getSouth() { return neighbors.get("south"); }
    public Room getEast()  { return neighbors.get("east"); }
    public Room getWest()  { return neighbors.get("west"); }
}
