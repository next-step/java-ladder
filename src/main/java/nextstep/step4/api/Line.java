package nextstep.step4.api;

import nextstep.step4.model.Point;

import java.util.List;

public interface Line {
    int move(int position);

    List<Point> getPoints();
}
