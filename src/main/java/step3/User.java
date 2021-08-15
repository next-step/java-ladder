package step3;

import step3.strategy.SideMoveStrategy;

import java.util.Optional;

public class User {
    public static final int USER_NAME_MAX_LENGTH = 5;

    private final String name;
    private final Position initialPosition;

    public User(String name, Position initialPosition) {
        validate(name);

        this.name = name;
        this.initialPosition = initialPosition;
    }

    private void validate(String name) {
        if (name.length() > USER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람의 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public Position sideMove(Line line, Position position) {
        Position currentPosition = Optional.ofNullable(position).orElse(this.initialPosition);
        SideMoveStrategy sideMoveStrategy = currentPosition.getMoveDirection(line);

        return sideMoveStrategy.move();
    }

    public boolean isMe(String name) {
        return this.name.equals(name);
    }

    public String toOutputString() {
        return name;
    }
}
