package ladder.domain.player;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int column) {
        this.name = new Name(name);
        this.position = new Position(column);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getCurrentHeight() {
        return this.position.getHeight();
    }

    public int getCurrentColumn() {
        return this.position.getColumn();
    }
}
