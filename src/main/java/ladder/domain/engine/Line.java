package ladder.domain.engine;

import java.util.List;

public interface Line {
    List<Point> getPoints();

    Players move(Players players);
}
