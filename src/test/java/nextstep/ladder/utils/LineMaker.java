package nextstep.ladder.utils;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Position;

public class LineMaker {

    private LineMaker() {
    }

    public static Line makeLine(int first_x, int first_y, int last_x, int last_y) {
        return new Line(new Position(first_x, first_y), new Position(last_x, last_y));
    }
}
