package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.Movement;
import nextstep.ladder.vo.Position;

/**
 * 다음 스텝으로 이동가능한 좌표를 가지는 클래스
 */
public class Step {
    private static final int MOVE_ONE = 1;

    private final Position linePosition;
    private final Position stepPosition;

    public Step(int linePosition, int stepPosition, Movement movement) {
        if (movement.isMovable()) {
            linePosition++;
        }
        this.linePosition = new Position(linePosition);
        this.stepPosition = new Position(stepPosition);
    }

    public Step(int linePosition, int stepPosition) {
        this(linePosition, stepPosition, () -> false);
    }

    public Step move() {
        return new Step(linePosition.getPosition(), stepPosition.getPosition() + MOVE_ONE);
    }

    public int getLinePosition() {
        return linePosition.getPosition();
    }

    public int getStepPosition() {
        return stepPosition.getPosition();
    }

    public boolean isMovable(int linePosition) {
        return this.linePosition.equals(new Position(linePosition));
    }

    @Override
    public String toString() {
        return linePosition.getPosition() + " " + stepPosition.getPosition();
    }
}
