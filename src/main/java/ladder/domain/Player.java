package ladder.domain;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public int max(int length) {
        if (name.length() > length) {
            return name.length();
        }

        return length;
    }

    public String getName() {
        return name;
    }
}
