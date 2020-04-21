package ladder.domain;

public interface LadderCreator {
    Ladder create(int playerCount, int height, DirectionCreator directionCreator);
}
