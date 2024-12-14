package ladder.domain.engine;

import ladder.domain.MatchingResult;

import java.util.List;

public interface Ladder {

    List<Line> lines();

    int move(int startPosition);

    MatchingResult play();
}
