package laddergame.domain;

import laddergame.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    private boolean currentPoint = false;

    public Line(int widthOfLadder, LineStrategy lineStrategy) {
        initLine(widthOfLadder-1, lineStrategy);
    }

    private void initLine(int sizeOfPoints, LineStrategy lineStrategy) {
        for (int i = 0; i < sizeOfPoints; i++) {
            currentPoint = lineExistOrEmpty(lineStrategy);
            points.add(currentPoint);
        }
    }

    private boolean lineExistOrEmpty(LineStrategy lineStrategy) {
        if(currentPoint){
            return false;
        }
        return lineStrategy.create();
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
