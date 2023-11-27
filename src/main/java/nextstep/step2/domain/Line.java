package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();
    private static final float PROBABILITY = 0.4f;

    public Line(int personCount) {
        generateLine(personCount);
    }

    private void generateLine(int personCount) {
        boolean previousValue = false;
        for (int i = 0; i < personCount-1; i++) {
            previousValue = generatePoint(previousValue);
        }
    }

    private boolean generatePoint(boolean previousValue) {
        if(previousValue) {
            previousValue = false;
            points.add(previousValue);
            return previousValue;
        }
        previousValue = Math.random() >= PROBABILITY;
        points.add(previousValue);
        return previousValue;
    }

    public List<Boolean> points() {
        return points;
    }
}
