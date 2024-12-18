package engine;

import nextstep.ladder.domain.Line;
import nextstep.ladder.strategy.LineStrategy;

import java.util.List;


public interface LinesCreator {
    void generateLine(int participantCnt, int maxLadder, LineStrategy lineStrategy);
    List<Line> getLines();
}
