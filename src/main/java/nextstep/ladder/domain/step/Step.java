package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.Movement;
import nextstep.ladder.vo.Position;

public class Step {
    private final Position line;
    private final Position step;

    public Step(int line, int step, Movement movement) {
        if (movement.isMovable()) {
            line++;
        }
        this.line = new Position(line);
        this.step = new Position(step);
    }

    public Step(int line, int step) {
        this(line, step, () -> false);
    }

    public Step move() {
        return new Step(line.getPosition(), step.getPosition() + 1);
    }

    public int getLine() {
        return line.getPosition();
    }

    public int getStep() {
        return step.getPosition();
    }

    public boolean isMovable(int i) {
        return line.equals(new Position(i));
    }

    @Override
    public String toString() {
        return line.getPosition() + " " + step.getPosition();
    }
}
