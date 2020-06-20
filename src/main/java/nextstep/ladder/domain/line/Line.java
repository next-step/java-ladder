package nextstep.ladder.domain.line;

import nextstep.ladder.strategy.LiningStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String POINT_LINED = "-----|";
    private static final String POINT_UNLINED = "     |";

    private final LiningStrategy liningStrategy;
    private final List<Boolean> points;

    public Line(LiningStrategy liningStrategy, int playerCount) {
        this.liningStrategy = liningStrategy;
        this.points = createPoints(playerCount);
    }

    private List<Boolean> createPoints(int playerCount) {
        List<Boolean> points = new ArrayList<>();
        boolean lined;

        for (int i = 0; i < playerCount - 1; i++) {
            lined = (i == 0 || !points.get(i-1)) && liningStrategy.canDrawLine();
            points.add(i, lined);
        }

        return points;
    }

    public int findNextPosition(int playerPosition) {
        if (isAfterLined(playerPosition)) {
            return playerPosition + 1;
        } else if (isBeforeLined(playerPosition)) {
            return playerPosition - 1;
        }

        return playerPosition;
    }

    private boolean isBeforeLined(int index) {
        if (index == 0) {
            return false;
        }

        return points.get(index - 1);
    }

    private boolean isAfterLined(int index) {
        if (index >= points.size()) {
            return false;
        }

        return points.get(index);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(POINT_UNLINED);

        points.forEach(point -> {
            String append = point ? POINT_LINED : POINT_UNLINED;
            stringBuilder.append(append);
        });

        return stringBuilder.toString();
    }
}
