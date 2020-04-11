package ladder.domain;

import java.util.Objects;

public class Node {
    private static final int FORWARD = 1;
    private static final int BACK = 0;

    private final User user;
    private Position position;

    public static Node of(User user, int startPosition) {
        return new Node(user, Position.of(startPosition));
    }

    public static Node of(String userName, int startPosition) {
        return new Node(User.of(userName), Position.of(startPosition));
    }

    private Node(User user, Position startPosition) {
        this.user = Objects.requireNonNull(user);
        this.position = Objects.requireNonNull(startPosition);
    }

    void move(LinkDirection linkDirection) {
        int direction = linkDirection.checkDirection(position);

        if (direction == BACK) {
            position = position.back();
        }

        if (direction == FORWARD) {
            position = position.forward();
        }
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(user, node.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
