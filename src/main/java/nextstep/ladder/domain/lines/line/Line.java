package nextstep.ladder.domain.lines.line;

import java.util.List;
import nextstep.ladder.domain.lines.point.Point;

public interface Line {

    boolean canMoveRight(int userIndex);

    boolean canMoveLeft(int userIndex);

    List<Point> getPoints();

    int size();
}

