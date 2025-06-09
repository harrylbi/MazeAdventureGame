import java.util.HashMap;
import java.util.Map;

public class Room {
    private String description;
    private Entity entity;
    private final Map<String, Room> neighbors = new HashMap<>();
    private boolean visited = false;

    public Room(String description) {
        this.description = description;
    }

    public void setNeighbor(String direction, Room room) {
        neighbors.put(direction, room);
    }

    public Room getNeighbor(String direction) {
        return neighbors.get(direction);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
