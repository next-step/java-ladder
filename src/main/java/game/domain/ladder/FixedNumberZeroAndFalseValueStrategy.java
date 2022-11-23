package game.domain.ladder;

public class FixedNumberZeroAndFalseValueStrategy implements ValueStrategy {
    @Override
    public int generateNumber() {
        return 0;
    }

    @Override
    public boolean generateBoolean() {
        return false;
    }
}
