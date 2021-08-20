package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPeople) {
        initLine(countOfPeople-1);
    }

    private void initLine(int sizeOfPoints) {
        boolean beforeIsTrue = false;

        for (int i = 0; i < sizeOfPoints; i++) {
            beforeIsTrue = getObject(beforeIsTrue);
            points.add(beforeIsTrue);
        }
    }

    private boolean getObject(boolean beforeIsTrue) {
        if(beforeIsTrue){
            return false;
        }
        return trueOrFalse();
    }

    private boolean trueOrFalse() {
        return (random.nextInt(2) < 1);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
