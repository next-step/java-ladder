package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfMembers, int height) {
        this(IntStream.range(0, height)
                .mapToObj((i) -> LineFactory.randomCreate(countOfMembers))
                .collect(Collectors.toList()));
    }

    public Ladder(List<Line> lines) {
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
}
