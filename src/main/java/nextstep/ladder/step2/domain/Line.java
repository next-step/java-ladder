package nextstep.ladder.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Line {
    private static final int START_INDEX = 1;
    private static final Random random = new Random();
    private List<Boolean> points;

    public Line() {
        this.points = new ArrayList<>();
        points.add(false);
    }

    public Line createLine(int playerCount) {
        for (int i = START_INDEX; i < playerCount; i++) {
            points.add(checkPreviousPoint(points.get(i - 1)));
        }
        return this;
    }

    public boolean checkPreviousPoint(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }
        return random.nextBoolean();
    }

    public int getPointSize() {
        return points.size();
    }

    public Stream<Boolean> stream() {
        return points.stream();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
