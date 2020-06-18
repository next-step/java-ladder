package nextstep.ladder.domain.line;

import nextstep.ladder.strategy.LiningStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String POINT_LINED = "-----|";
    private static final String POINT_UNLINED = "     |";

    private final List<Boolean> points = new ArrayList<>();
    private final LiningStrategy liningStrategy;

    public Line(LiningStrategy liningStrategy, int playerCount) {
        this.liningStrategy = liningStrategy;
        createLine(playerCount);
    }

    private void createLine(int playerCount) {
        boolean lined;

        for(int i = 0; i < playerCount-1; i++) {
            lined = (i == 0 || !isBeforeLined(i)) && liningStrategy.canDrawLine();
            points.add(i, lined);
        }
    }

    public int findNextPosition(int playerPosition) {
        return isAfterLined(playerPosition) ? playerPosition + 1 : (isBeforeLined(playerPosition) ? playerPosition - 1 : playerPosition);
    }

    private boolean isBeforeLined(int index) {
        if(index == 0) {
            return false;
        }

        return points.get(index - 1);
    }

    private boolean isAfterLined(int index) {
        if(index >= points.size()) {
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
