package ladder.utils;

import ladder.domain.ladder.Direction;

import java.util.List;

public class LineUtil {

    private LineUtil() {
    }

    public static Direction getLastDirection(List<Direction> directions) {
        return directions.get(directions.size() - 1);
    }
}
