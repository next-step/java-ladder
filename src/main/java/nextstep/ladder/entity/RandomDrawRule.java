package nextstep.ladder.entity;

public class RandomDrawRule implements DrawRule {
    @Override
    public Direction isDrawable() {
        return (int) (Math.random() * 2) == 1 ? Direction.RIGHT : Direction.NONE;
    }
}
