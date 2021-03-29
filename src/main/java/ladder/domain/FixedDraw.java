package ladder.domain;

public class FixedDraw implements DrawStrategy {

    @Override
    public boolean drawValue() {
        return true;
    }
}
