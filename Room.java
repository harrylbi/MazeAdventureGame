public class Room {
    private String description;
    private Room north, south, east, west;
    private Entity entity;

    public Room(String description) {
        this.description = description;
    }

    public void setNeighbor(String direction, Room neighbor) {
        switch (direction.toLowerCase()) {
            case "north" -> this.north = neighbor;
            case "south" -> this.south = neighbor;
            case "east"  -> this.east = neighbor;
            case "west"  -> this.west = neighbor;
        }
    }

    public Room getNorth() { return north; }
    public Room getSouth() { return south; }
    public Room getEast()  { return east; }
    public Room getWest()  { return west; }

    public String getDescription() {
        return description;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
