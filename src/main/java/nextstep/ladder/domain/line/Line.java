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

    private boolean isBeforeLined(int index) {
        return points.get(index - 1);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("    |");

        points.forEach(point -> {
            String append = point ? POINT_LINED : POINT_UNLINED;
            stringBuilder.append(append);
        });

        return stringBuilder.toString();
    }
}
