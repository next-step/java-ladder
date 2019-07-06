package ladder.model;

public class Player {

    private final String name;
    private Position position;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public String getName() {
        return name;
    }

    public Position ride(Direction direction) {
        this.position = direction.move(this.position);
        return this.position;
    }
}
