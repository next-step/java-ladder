package nextstep.ladder.domain.ladder;

import java.util.Objects;
import java.util.Optional;

/**
 * 사다리 가로대(발판)
 */
public class Rung {
    private final Connection connection;
    private final Direction direction;

    public static Rung empty() {
        return new Rung(Connection.EMPTY, Direction.NONE);
    }

    public Rung(Connection connection) {
        this(connection, connection.generateDirection());
    }

    public Rung(Connection connection, Direction direction) {
        this.connection = connection;
        this.direction = direction;
    }

    public Rung generate(RungGenerateStrategy generateStrategy) {
        return Optional.ofNullable(generateStrategy)
                .map(strategy -> {
                    if (notConnected() || leftConnected()) {
                        return new Rung(Connection.from(generateStrategy.addable()));
                    }

                    return new Rung(Connection.EXIST, Direction.LEFT);
                })
                .orElse(empty());
    }

    public boolean notConnected() {
        return connection.notExist();
    }

    public boolean rightConnected() {
        return connection.exist() && direction.isRight();
    }

    public boolean leftConnected() {
        return connection.exist() && direction.isLeft();
    }

    public ColumnIndex moveFrom(ColumnIndex currentIndex) {
        return direction.next(currentIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rung rung = (Rung) o;
        return connection == rung.connection && direction == rung.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection, direction);
    }
}
