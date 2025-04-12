package nextstep.ladder.domain;

public class Junction {
    private final Leg leg;
    private final JunctionNeighbors neighbors = new JunctionNeighbors();
    private final JunctionVisitors visitors = new JunctionVisitors();

    public Junction(Leg leg) {
        this.leg = leg;
    }

    public boolean hasLeft() {
        return neighbors.hasLeft();
    }

    public boolean hasRight() {
        return neighbors.hasRight();
    }

    public boolean hasByDirection(Direction direction) {
        return neighbors.hasByDirection(direction);
    }

    public boolean hasDown() {
        return neighbors.hasDown();
    }

    public boolean hasLeftOrRight() {
        return neighbors.hasLeftOrRight();
    }

    public void setLeft(Junction left) {
        neighbors.setLeft(left);
    }

    public void setRight(Junction right) {
        neighbors.setRight(right);
    }

    public void setDown(Junction down) {
        neighbors.setDown(down);
    }

    public void connectRight(Junction right) {
        neighbors.connectRight(this, right);
    }

    public void connectDown(Junction down) {
        neighbors.connectDown(this, down);
    }

    public Junction getByDirection(Direction direction) {
        return neighbors.getByDirection(direction);
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
