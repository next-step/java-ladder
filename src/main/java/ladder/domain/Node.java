package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Node {
    public static final Random RANDOM = new Random();
    private final boolean left;
    private final boolean current;

    public Node(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }

    public static Node first(boolean current) {
        return new Node(false, current);
    }

    public static Node firstRandom() {
        return new Node(false, RANDOM.nextBoolean());
    }

    public Node next(boolean current) {
        return new Node(this.current, current);
    }

    public Node nextRandom() {
        if (this.current) {
            return new Node(true, false);
        }
        return new Node(false, RANDOM.nextBoolean());
    }

    public Direction move() {
        if (this.current && this.left) {
            throw new IllegalArgumentException("left and current cannot be true at the same time.");
        }
        if (this.current) {
            return Direction.RIGHT;
        }
        if (this.left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public Node last() {
        return new Node(this.current, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return left == node.left && current == node.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
