package ladder.domain;

public class Player {
    private final String name;

    public Player(final String name) {
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > 5) {

        }
    }

    public String getName() {
        return name;
    }
}
