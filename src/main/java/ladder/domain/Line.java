package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MINIMUM_PLAYER_COUNTS = 1;
    private final List<Point> points = new ArrayList<>();

    public Line(int playerCounts) {
        validatePlayerCounts(playerCounts);
        for (int i = 0; i < (playerCounts - 1) * 5; i++) {
            points.add(new Point(true));
        }
    }

    private void validatePlayerCounts(int playerCounts) {
        if (playerCounts < MINIMUM_PLAYER_COUNTS) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PLAYER_COUNTS);
        }
    }

    public int getLineSize() {
        return points.size();
    }
}
