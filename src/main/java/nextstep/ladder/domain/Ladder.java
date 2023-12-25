package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final int countOfMembers;
    private final List<Line> lines;

    public Ladder(int countOfMembers, List<Line> lines) {
        this.countOfMembers = countOfMembers;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return lines.size();
    }

    private int getResult(int idx) {
        for (Line line : lines) {
            idx = line.move(idx);
        }
        return idx;
    }

    public MatchingResult play() {
        MatchingResult matchingResult = new MatchingResult();
        IntStream.range(0, countOfMembers)
                .forEach(memberIDX -> {
                    matchingResult.mappingIDX(memberIDX, getResult(memberIDX));
                });
        return matchingResult;
    }
}
