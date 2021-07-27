package nextstep.ladder.domain.player;

public class Player {
    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player init(String name) {
        return new Player(name);
    }
}
