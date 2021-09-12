package nextstep.ladder.model;

public class OneByTwoDrawStrategy implements DrawStrategy {
    private boolean draw = true;

    @Override
    public boolean draw() {
        draw = !draw;
        return draw;
    }
}
