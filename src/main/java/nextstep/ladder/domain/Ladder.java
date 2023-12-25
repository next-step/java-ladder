package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int countOfMembers;
    private final List<Line> lines;

    public Ladder(int countOfMembers, int height) {
        this(countOfMembers,
                IntStream.range(0, height)
                        .mapToObj((i) -> LineFactory.randomCreate(countOfMembers))
                        .collect(Collectors.toList()));
    }

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

    public LadderResult getResults(JoinMembers joinMembers, List<String> prizes) {
        LadderResult ladderResult = new LadderResult();
        IntStream.range(0, joinMembers.countOfMembers())
                .forEach(memberIDX -> {
                    int prizeIDX = getResult(memberIDX);
                    ladderResult.addResult(joinMembers.getMember(memberIDX), prizes.get(prizeIDX));
                });
        return ladderResult;
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
