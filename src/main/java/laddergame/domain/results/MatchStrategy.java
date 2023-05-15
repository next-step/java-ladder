package laddergame.domain.results;

import java.util.List;
import laddergame.domain.line.Line;

public interface MatchStrategy {

    int getMatchedIndex(int position, List<Line> lines);
}
