package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MINIMUM_PLAYER_COUNTS = 1;
    private final List<Boolean> points = new ArrayList<>();

    public Line(int playerCounts) {
        validatePlayerCounts(playerCounts);
    }

    private void validatePlayerCounts(int playerCounts) {
        if (playerCounts < MINIMUM_PLAYER_COUNTS) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PLAYER_COUNTS);
        }
    }
}
