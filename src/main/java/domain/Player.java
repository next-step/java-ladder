package domain;

public class Player {

    public static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
