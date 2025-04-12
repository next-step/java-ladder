package nextstep.ladder.domain;

public class Junction {
    private final Leg leg;
    private final NextJunction next = new NextJunction();
    private final JunctionVisitors visitors = new JunctionVisitors();

    public Junction(Leg leg) {
        this.leg = leg;
    }

    public boolean hasLeft() {
        return next.hasLeft();
    }

    public boolean hasRight() {
        return next.hasRight();
    }

    public boolean hasDown() {
        return next.hasDown();
    }

    public boolean hasLeftOrRight() {
        return next.hasLeftOrRight();
    }

    private boolean hasNext() {
        return next.hasNext();
    }

    public Junction getNext() {
        return next.getNext();
    }

    public void setLeft(Junction left) {
        next.setLeft(left);
    }

    public void setRight(Junction right) {
        next.setRight(right);
    }

    public void setDown(Junction down) {
        next.setDown(down);
    }

    public void connectRight(Junction right) {
        next.connectRight(this, right);
    }

    public void connectDown(Junction down) {
        next.connectDown(this, down);
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
        if (!hasNext()) {
            return false;
        }

        return !getNext().isVisited(name);
    }

    private Junction move(ParticipantName visitor) {
        Junction next = getNext();
        next.visit(visitor);
        return next;
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
