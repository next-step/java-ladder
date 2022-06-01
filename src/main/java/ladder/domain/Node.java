package ladder.domain;

import ladder.util.Random;

import java.util.Objects;

public class Node {
    private final boolean left;
    private final boolean right;

    public Node(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("left and right cannot be true consecutively.");
        }
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
        return new Node(false, Random.createBoolean());
    }

    public Node next(boolean current) {
        return new Node(this.right, current);
    }

    public Node nextRandom() {
        if (this.right) {
            return new Node(true, false);
        }
        return new Node(false, Random.createBoolean());
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

    public Boolean isLeft() {
        return this.left;
    }

    public Boolean isRight() {
        return this.right;
    }
}
