package ladder;

import java.util.Random;

public enum DirectionMoveState {
    POSSIBLE,
    IMPOSSIBLE;

    public boolean isPossible() {
        return this == POSSIBLE;
    }

    public static DirectionMoveState getRandomMoveState() {
        boolean isPossible = new Random().nextBoolean();
        return isPossible ? POSSIBLE : IMPOSSIBLE;
    }
}
