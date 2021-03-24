package ladder.domain;

public class Player {

    private final Name name;

    private final Position startPosition;

    public Player(String name, int ladderNumber) {
        this(new Name(name), new Position(ladderNumber));
    }

    public Player(Name name, Position position) {
        this.name = name;
        this.startPosition = position;
    }

    public String name() {
        return name.toString();
    }

    public boolean isMatch(String playerName) {
        return name.equals(new Name(playerName));
    }

    public Position startPosition() {
        return startPosition;
    }
}
