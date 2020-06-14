package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String POINT_TRUE = "-----";
    private static final String POINT_FALSE = "     ";

    private final List<Boolean> points = new ArrayList<>();
    private final Random random = new Random();

    public Line(int playerCount) {
        createLine(playerCount);
    }

    private void createLine(int playerCount) {
        for(int i = 0; i < playerCount; i++) {
            if(i == 0 || !points.get(i-1)) {
                points.add(i, getRandomBoolean());
            } else {
                points.add(i, false);
            }
        }
    }

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("|");

        points.forEach(point -> {
            if(point) {
                stringBuilder.append(POINT_TRUE);
            } else {
                stringBuilder.append(POINT_FALSE);
            }

            stringBuilder.append("|");
        });

        return stringBuilder.toString();
    }
}
