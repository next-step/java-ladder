package domain;

public class Player {
    private String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
