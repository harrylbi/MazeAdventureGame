public abstract class Entity {
    protected String name;
    protected char symbol;

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
}
