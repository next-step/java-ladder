package nextstep.ladder.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private List<Boolean> points;

    public Line() {
        this.points = new ArrayList<>();
        points.add(false);
    }

    public void createLine(int playerCount) {
        for (int i = 1; i < playerCount; i++) {
            points.add(checkPreviousPoint(points.get(i-1)));
        }
    }

    public boolean checkPreviousPoint(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
