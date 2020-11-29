package ladder.domain.ladder;

public interface DirectionGenerator {
    Direction generateFirst();

    Direction generateNext(Direction beforeDirection);

    default Direction generateLast(final Direction direction) {
        return Direction.valueOf(direction.hasRight(), Boolean.FALSE);
    }
}