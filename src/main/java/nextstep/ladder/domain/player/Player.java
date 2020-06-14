package nextstep.ladder.domain.player;

public class Player {
    private final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }
}
