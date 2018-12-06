package ladder.domain;

import java.util.Arrays;

public enum DirectionSelection {

    LEFT                             (Boolean.TRUE , Boolean.FALSE),
    RIGHT                            (Boolean.FALSE, Boolean.TRUE ),
    DOWN                             (Boolean.FALSE, Boolean.FALSE);

    private boolean leftPoint;
    private boolean rightPoint;

    DirectionSelection(boolean leftPoint, boolean rightPoint) {
        if (leftPoint && rightPoint) {
            throw new IllegalStateException();
        }
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public static DirectionSelection of(boolean first, boolean second) {
        return Arrays.stream(DirectionSelection.values())
                .filter(
                        direction ->
                                direction.leftPoint == first &&
                                direction.rightPoint == second)
                .findAny()
                .orElseThrow(() -> new IllegalStateException());
    }

    public int move(int index) {
        if(this == RIGHT)
            return index + 1;
        if(this == LEFT)
            return index - 1;
        return index;

    }
}
