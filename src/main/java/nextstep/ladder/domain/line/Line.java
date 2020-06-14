package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private final Random random = new Random();

    public Line(int playerCount) {
        createLine(playerCount);
    }

    private void createLine(int playerCount) {

        for(int i = 0; i < playerCount; i++) {
            if(i == 0 || !points.get(i-1)) {
                points.add(i, getRandomBoolean());
            }

            points.add(i, false);
        }
    }

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
