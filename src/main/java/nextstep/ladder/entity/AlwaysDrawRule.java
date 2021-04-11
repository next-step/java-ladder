package nextstep.ladder.entity;

public class AlwaysDrawRule implements DrawRule {
    @Override
    public Direction nextDirection() {
        return Direction.RIGHT ;
    }
}
