package ladder.domain.interfaces;

import java.util.List;

public interface Line {
    List<Point> getPoints();

    Players move(Players players);
}
