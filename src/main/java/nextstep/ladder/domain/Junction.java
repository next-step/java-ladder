package nextstep.ladder.domain;

public class Junction {
    private final Leg leg;
    private final JunctionNeighbors neighbors = new JunctionNeighbors();

    public Junction(Leg leg) {
        this.leg = leg;
    }

    public boolean hasLeft() {
        return hasNeighbor(Direction.LEFT);
    }

    public boolean hasRight() {
        return hasNeighbor(Direction.RIGHT);
    }

    public boolean hasDown() {
        return hasNeighbor(Direction.DOWN);
    }

    public boolean hasNeighbor(Direction direction) {
        return neighbors.hasNeighbor(direction);
    }

    public boolean hasLeftOrRight() {
        return hasLeft() || hasRight();
    }

    public void connectRight(Junction right) {
        this.neighbors.setNeighbor(Direction.RIGHT, right);
        right.neighbors.setNeighbor(Direction.LEFT, this);
    }

    public void connectDown(Junction down) {
        this.neighbors.setNeighbor(Direction.DOWN, down);
    }

    public Junction getNeighbor(Direction direction) {
        return neighbors.getNeighbor(direction);
    }

    public ParticipantName getName() {
        return leg.getName();
    }

    public String getResult() {
        return leg.getResult();
    }

}
