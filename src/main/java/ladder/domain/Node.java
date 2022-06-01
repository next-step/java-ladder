package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Node {
    public static final Random RANDOM = new Random();
    private final boolean left;
    private final boolean right;

    public Node(boolean left, boolean current) {
        this.left = left;
        this.right = current;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", current=" + right +
                '}';
    }

    public static Node first(boolean current) {
        return new Node(false, current);
    }

    public static Node firstRandom() {
        return new Node(false, RANDOM.nextBoolean());
    }

    public Node next(boolean current) {
        return new Node(this.right, current);
    }

    public Node nextRandom() {
        if (this.right) {
            return new Node(true, false);
        }
        return new Node(false, RANDOM.nextBoolean());
    }

    public Direction move() {
        if (this.right && this.left) {
            throw new IllegalArgumentException("left and current cannot be true at the same time.");
        }
        if (this.right) {
            return Direction.RIGHT;
        }
        if (this.left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public Node last() {
        return new Node(this.right, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return left == node.left && right == node.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public String toShow() {
        return (this.right ? "-" : " ").repeat(5);
    }
}
