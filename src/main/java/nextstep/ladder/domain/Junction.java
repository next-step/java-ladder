package nextstep.ladder.domain;

public class Junction {
    private final Leg leg;
    private final JunctionNeighbors neighbors = new JunctionNeighbors();
    private final JunctionVisitors visitors = new JunctionVisitors();

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

    boolean hasNeighbor(Direction direction) {
        return neighbors.hasNeighbor(direction);
    }

    public boolean hasLeftOrRight() {
        return hasLeft() || hasRight();
    }

    public void setLeft(Junction left) {
        neighbors.setNeighbor(Direction.LEFT, left);
    }

    public void setRight(Junction right) {
        neighbors.setNeighbor(Direction.RIGHT, right);
    }

    public void setDown(Junction down) {
        neighbors.setNeighbor(Direction.DOWN, down);
    }

    public void connectRight(Junction right) {
        neighbors.connectRight(this, right);
    }

    public void connectDown(Junction down) {
        neighbors.connectDown(this, down);
    }

    Junction getNeighbor(Direction direction) {
        return neighbors.getNeighbor(direction);
    }

    public ParticipantName getName() {
        return leg.getName();
    }

    public String getResult() {
        return leg.getResult();
    }

    public void visit(ParticipantName name) {
        visitors.visit(name);
    }

    public boolean isVisited(ParticipantName visitor) {
        return visitors.isVisited(visitor);
    }

    public Junction moveToResult(ParticipantName visitor) {
        Junction curr = this;
        curr.visit(visitor);

        while (JunctionMover.canMove(curr, visitor)) {
            curr = JunctionMover.move(curr, visitor);
        }

        return curr;
    }

}
