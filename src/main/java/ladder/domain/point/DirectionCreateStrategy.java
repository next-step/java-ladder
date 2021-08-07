package ladder.domain.point;

public interface DirectionCreateStrategy {
    Direction next(Direction current);

    Direction first();

    Direction last(Direction current);
}
