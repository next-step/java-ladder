package laddergame.domain.player;

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

    public boolean isSameName(String name) {
        return isSameName(new Name(name));
    }

    public boolean isSameName(Name name) {
        return this.name.equals(name);
    }

    public int getCurrentHeight() {
        return this.position.getHeight();
    }

    public int getCurrentColumn() {
        return this.position.getColumn();
    }

    public Position getPosition() {
        return position;
    }
}
