package ladder.domain.impl;

import ladder.domain.MatchingResult;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.Line;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderImpl implements Ladder {

    private final List<Line> lines;

    private LadderImpl(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        return new LadderImpl(lines);
    }

    @Override
    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public int move(int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    @Override
    public MatchingResult play() {
        Map<Integer, Integer> matchingResult = new HashMap<>();
        for (int start = 0; start < lines.size() - 1; start++) {
            int end = move(start);
            matchingResult.put(start, end);
        }
        return MatchingResult.of(matchingResult);
    }

}
