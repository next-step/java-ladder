package nextstep.ladder.model.v1;

public class OneByTwoDrawStrategy implements DrawStrategy {
    private boolean draw;

    public OneByTwoDrawStrategy(boolean initialDraw) {
        this.draw = initialDraw;
    }

    @Override
    public boolean draw() {
        draw = !draw;
        return draw;
    }
}
