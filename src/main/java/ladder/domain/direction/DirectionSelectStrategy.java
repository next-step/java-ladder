package ladder.domain.direction;

@FunctionalInterface
public interface DirectionSelectStrategy {
    boolean isRight();
}
