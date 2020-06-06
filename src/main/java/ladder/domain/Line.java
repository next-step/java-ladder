package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int playerCounts) {
        if (playerCounts < 1) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PLAYER_COUNTS);
        }
    }
}
