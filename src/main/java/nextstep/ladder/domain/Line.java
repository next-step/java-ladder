package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private List<Direction> directions;

    public Line(List<Direction> directions) {
        this.directions = directions;
    }

    public int height() {
        return directions.size();
    }

    public Direction getDirectionOfHeight(int height) {
        return directions.get(height);
    }
}
