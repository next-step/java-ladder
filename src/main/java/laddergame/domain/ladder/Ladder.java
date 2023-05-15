package laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;
import laddergame.domain.line.Line;
import laddergame.domain.results.Match;
import laddergame.domain.results.MatchStrategy;

public class Ladder {

    private final List<Line> lines;
    private final MatchStrategy matchStrategy;

    public Ladder(List<Line> lines, MatchStrategy matchStrategy) {
        this.lines = lines;
        this.matchStrategy = matchStrategy;
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
        this.matchStrategy = new Match();
    }

    public static Ladder of(List<Line> lines, MatchStrategy matchStrategy) {
        return new Ladder(lines, matchStrategy);
    }

    public int getMatchedIndex(int position) {
        return matchStrategy.getMatchedIndex(position, lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
