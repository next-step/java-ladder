package nextstep.ladder.entity;

public class LastPointNoneDrawRule implements DrawRule {
    @Override
    public Direction nextDirection() {
        return Direction.NONE ;
    }
}
