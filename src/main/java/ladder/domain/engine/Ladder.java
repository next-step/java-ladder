package ladder.domain.engine;

import java.util.List;

public interface Ladder {
    LadderResults ladderResults(Players players, ExecutionResults executionResults);
    List<Line> lines();
}
