package nextstep.ladder.domain;

public class Position {

    private final int position;
    private final Step step;

    public Position(int position, Step step) {
        this.position = position;
        this.step = step;
    }

    public int move() {
        if (step.move() == Direction.RIGHT) {
            return this.position + 1;
        }

        if (step.move() == Direction.LEFT) {
            return this.position - 1;
        }
        return this.position;
    }
}
