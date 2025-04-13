package nextstep.ladder.game;

import nextstep.ladder.enums.Direction;

import java.util.List;

public class Row {
    private final List<Direction> directions;

    public Row(List<Direction> directions) {
        this.directions = directions;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public Integer nextPosition(int position) {
        Direction direction = directions.get(position);

        return position + direction.append;
    }
}
