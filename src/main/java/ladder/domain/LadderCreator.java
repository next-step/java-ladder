package ladder.domain;

@FunctionalInterface
public interface LadderCreator {
    Ladder create(int playerCount, int height, DirectionCreator directionCreator);
}
