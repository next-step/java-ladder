package nextstep.ladder.domain.user;

import java.util.function.Consumer;

public enum Direction {

    LEFT(Position::moveLeft),
    RIGHT(Position::moveRight),
    NONE(position -> {
    });

    private final Consumer<Position> positionConsumer;

    Direction(Consumer<Position> positionConsumer) {
        this.positionConsumer = positionConsumer;
    }

    public void move(Position position) {
        positionConsumer.accept(position);
        position.moveDown();
    }

}
