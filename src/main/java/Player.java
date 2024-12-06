public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public int nameLength() {
        return name.length();
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
