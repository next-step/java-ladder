package nextstep.ladder.model;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException("name must not be longer than 5");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
