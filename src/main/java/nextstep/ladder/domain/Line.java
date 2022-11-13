package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(Boolean.FALSE);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getPointSize() {
        return points.size();
    }

    public boolean getPoint(int index) {
        return points.get(index);
    }

    public void generateConnection() {
        Random random = new Random();

        for (int i = 0; i < points.size() - 1; i++) {
            connectRightOrNot(random, i);
        }
    }

    private void connectRightOrNot(Random random, int index) {
        if (isConnectable(random, index - 1)) {
            connectPoints(index, index + 1);
        }
    }

    protected boolean isConnectable(Random random, int frontIndex) {
        if (frontIndex < 0) {
            return random.nextBoolean();
        }

        return random.nextBoolean() && !points.get(frontIndex);
    }

    private void connectPoints(int firstIndex, int secondIndex) {
        points.set(firstIndex, true);
        points.set(secondIndex, true);
    }
}
