package ladder.domain;

import ladder.domain.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class JerryLine implements ladder.engine.Line {
    private List<Direction> points = new ArrayList<>();

    public JerryLine(List<Direction> points) {
        this.points = points;
    }

    public List<Direction> getPoints() {
        return points;
    }

    public int getNextPosition(int currentPosition) {
        return points.get(currentPosition).getNext(currentPosition);
    }

}
