package nextstep.ladder.domain.ladder;

import java.util.function.Function;

public enum Step {
    LEFT(LadderPosition::moveLeft),
    RIGHT(LadderPosition::moveRight),
    NONE(prevPosition -> prevPosition);

    private final Function<LadderPosition, LadderPosition> determinant;

    Step(Function<LadderPosition, LadderPosition> determinant) {
        this.determinant = determinant;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public LadderPosition move(LadderPosition ladderPosition) {
        return determinant.apply(ladderPosition);
    }
}
