package nextstep.ladder.domain;

public class Junction {
    private final Leg leg;
    private final JunctionNeighbors neighbors = new JunctionNeighbors();
    private final JunctionVisitors visitors = new JunctionVisitors();

    public Junction(Leg leg) {
        this.leg = leg;
    }

    public boolean hasLeft() {
        return neighbors.getLeft() != null;
    }

    public boolean hasRight() {
        return neighbors.getRight() != null;
    }

    public boolean hasDown() {
        return neighbors.getDown() != null;
    }

    public Junction getLeft() {
        return neighbors.getLeft();
    }

    public Junction getRight() {
        return neighbors.getRight();
    }

    public Junction getDown() {
        return neighbors.getDown();
    }

    public void setLeft(Junction junction) {
        neighbors.setLeft(junction);
    }

    public void setRight(Junction junction) {
        neighbors.setRight(junction);
    }

    public void setDown(Junction junction) {
        neighbors.setDown(junction);
    }

    private void connect(Direction direction, Junction junction) {
        direction.connect(this, junction);
    }

    public void connectRight(Junction right) {
        connect(Direction.RIGHT, right);
    }

    public void connectDown(Junction down) {
        connect(Direction.DOWN, down);
    }

    public boolean hasLeftOrRight() {
        return this.hasLeft() || this.hasRight();
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

    public boolean canMove(ParticipantName name) {
        return Directions.canMove(this, name);
    }

    private Junction move(ParticipantName visitor) {
        return Directions.move(this, visitor);
    }

    public Junction moveToResult(ParticipantName visitor) {
        Junction curr = this;
        curr.visit(visitor);

        while (curr.canMove(visitor)) {
            curr = curr.move(visitor);
        }

        return curr;
    }

}
