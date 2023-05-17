package nextstep.ladder.domain;

public class Position {

    private static final int MOVE = 1;

    private final int position;
    private final Step step;

    public Position(int position, Step step) {
        this.position = position;
        this.step = step;
    }

    public int move() {
        if (step.isRight()) {
            return this.position + MOVE;
        }

        return moveLeftOrStay();
    }

    private int moveLeftOrStay() {
        if (step.isLeft()) {
            return this.position - MOVE;
        }

        return this.position;
    }
}
