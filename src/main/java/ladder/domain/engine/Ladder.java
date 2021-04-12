package ladder.domain.engine;

import java.util.List;

public interface Ladder {
    public LadderResults ladderResults(Players players, ExecutionResults executionResults);
    public List<Line> lines();
}
