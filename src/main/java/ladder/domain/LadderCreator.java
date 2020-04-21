package ladder.domain;

public interface LadderCreator {
    Ladder create(LadderInfo ladderInfo, DirectionCreator directionCreator);
}
