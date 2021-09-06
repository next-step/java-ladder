package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int LAST_LADDER_OFFSET = 2;

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, LineMakeStrategy ladderMakeStrategy) {
        points.add(ladderMakeStrategy.canMake());
        for (int i = 0; i < countOfPerson - LAST_LADDER_OFFSET; i++) {
            addPoint(points.get(i), ladderMakeStrategy);
        }
    }

    private void addPoint(boolean beforePointExist, LineMakeStrategy lineMakeStrategy) {
        if (beforePointExist) {
            points.add(false);
            return;
        }
        points.add(lineMakeStrategy.canMake());
    }


    public List<Boolean> getPoints() {
        return points;
    }

    public Direction findMoveDirection(int position) {
        if (points.get(position)) {
            return Direction.RIGHT;
        }
        if (points.get(position - Position.OFFSET)) {
            return Direction.RIGHT;
        }
        return Direction.MIDDLE;
    }


}
