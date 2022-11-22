package game.domain.ladder;

public class FixedNumberOneAndTrueValueStrategy implements ValueStrategy {
    @Override
    public int generateNumber() {
        return 1;
    }

    @Override
    public boolean generateBoolean() {
        return true;
    }
}
