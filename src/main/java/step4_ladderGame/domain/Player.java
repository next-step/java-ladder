package step4_ladderGame.domain;

public class Player {

    private final Name name;
    private final Position position;

    private Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Player of(String name, int position) {
        return new Player(Name.of(name), Position.of(position));
    }

}
