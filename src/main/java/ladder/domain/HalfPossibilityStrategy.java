package ladder.domain;

public class HalfPossibilityStrategy implements PossibilityStrategy {

    private static final double HALF_VALUE = 0.5;

    @Override
    public boolean check() {
        return Math.random() >= HALF_VALUE;
    }
}
