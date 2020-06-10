package ladder.domain.player;

public class Player {

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        validate(name);
        return new Player(name);
    }

    private static void validate(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("No name exception.");
        }
    }

    public String getName() {
        return name;
    }
}
