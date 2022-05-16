package nextstep.ladder.domain.strategy;

public class Horizontal implements HorizontalStrategy {
    private static final int HORIZONTAL_BASE_NUMBER = 10;
    private final int number;
    private final boolean left;

    public Horizontal(int number, boolean left) {
        this.number = number;
        this.left = left;
    }

    @Override
    public boolean canHorizontal() {
        return number > HORIZONTAL_BASE_NUMBER && !left;
    }
}
