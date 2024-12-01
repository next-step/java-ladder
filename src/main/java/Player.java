public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public int nameLength() {
        return name.length();
    }

    @Override
    public String toString() {
        return name;
    }
}
