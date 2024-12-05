package ladder.domain.engine;

import java.util.List;

public interface Ladder {

    List<Line> lines();

    int move(int startPosition);
}
