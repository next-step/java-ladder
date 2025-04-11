package nextstep.ladder.domain;

public class NextJunction {

    public Direction direction;
    public Junction next;

    public void connectRight(Junction left, Junction right) {
        left.setRight(right);
        right.setLeft(left);
    }

    public void connectDown(Junction up, Junction down) {
        up.setDown(down);
    }

    public void setLeft(Junction left) {
        next = left;
        direction = Direction.LEFT;
    }

    public void setRight(Junction right) {
        next = right;
        direction = Direction.RIGHT;
    }

    public void setDown(Junction down) {
        next = down;
        direction = Direction.DOWN;
    }

    public boolean hasRight() {
        return direction == Direction.RIGHT;
    }

    public boolean hasLeft() {
        return direction == Direction.LEFT;
    }

    public boolean hasDown() {
        return direction == Direction.DOWN;
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    public boolean hasLeftOrRight() {
        return hasLeft() || hasRight();
    }

    public Junction getNext() {
        return next;
    }
}
