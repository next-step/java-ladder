package ladderGame.domain;

public class Player {

    private final String name;
    private Position position;

    private Player(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public static Player of(String name, int position) {
        return new Player(name, position);
    }

    public void ride(DirectionLayer directionLayer) {
        this.position = position.moveBy(directionLayer);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
