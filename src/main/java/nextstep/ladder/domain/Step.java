package nextstep.ladder.domain;

public class Step {
    private final int position;
    private final boolean moveNextLine;

    private Step(int position, boolean moveNextLine) {
        this.position = position;
        this.moveNextLine = moveNextLine;
    }

    public static Step of(int position, MovableStrategy movableStrategy) {
        return new Step(position, movableStrategy.isMovable());
    }

    public int getPosition() {
        return position;
    }

    public boolean isMoveNextLine() {
        return moveNextLine;
    }
}
