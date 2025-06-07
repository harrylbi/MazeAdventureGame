public abstract class Entity {
    private String name;
    private char symbol;
    private boolean active = true;

    public Entity(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public abstract void interact(Player player);

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }
}
