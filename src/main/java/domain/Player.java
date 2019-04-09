package domain;

public class Player {
    private String name;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    public Player(String name) {
        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
