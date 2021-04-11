package nextstep.ladder.entity;

public class RandomDrawRule implements DrawRule {
    @Override
    public Direction nextDirection() {
        return (int) (Math.random() * 10) > 4 ? Direction.RIGHT : Direction.NONE;
    }
}
