package nextstep.ladder.domain.ladder;

import java.util.Objects;
import java.util.Optional;

/**
 * 사다리 가로대(발판)
 */
public class Rung {
    private final Direction direction;

    public static Rung empty() {
        return new Rung(Direction.NONE);
    }

    public Rung(Direction direction) {
        this.direction = direction;
    }

    public Rung generate(RungGenerateStrategy generateStrategy) {
        return Optional.ofNullable(generateStrategy)
                .map(strategy -> {
                    if (notConnected() || leftConnected()) {
                        return new Rung(Direction.from(generateStrategy.addable()));
                    }

                    return new Rung(Direction.LEFT);
                })
                .orElse(empty());
    }

    public boolean notConnected() {
        return direction.notConnected();
    }

    public boolean rightConnected() {
        return direction.isRight();
    }

    public boolean leftConnected() {
        return direction.isLeft();
    }

    public ColumnIndex moveFrom(ColumnIndex currentIndex) {
        return direction.next(currentIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rung rung = (Rung) o;
        return direction == rung.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
