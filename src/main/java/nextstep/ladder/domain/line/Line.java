package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String POINT_LINED = "-----|";
    private static final String POINT_UNLINED = "     |";

    private final List<Boolean> points = new ArrayList<>();
    private final Random random = new Random();

    public Line(int playerCount) {
        createLine(playerCount);
    }

    private void createLine(int playerCount) {
        boolean lined;

        for(int i = 0; i < playerCount-1; i++) {
            lined = (i == 0 || !isBeforeLined(i)) ? getRandomBoolean() : false;
            points.add(i, lined);
        }
    }

    private boolean isBeforeLined(int index) {
        return points.get(index - 1);
    }

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
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
