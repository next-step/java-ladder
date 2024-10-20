package nextstep.ladder.model;

public class Player {
    private String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name is too long");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
