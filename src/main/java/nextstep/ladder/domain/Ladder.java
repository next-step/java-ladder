package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final JoinMembers joinMembers;
    private final List<Line> lines;

    public Ladder(String names, int height) {
        this(new JoinMembers(names), height);
    }

    public Ladder(JoinMembers joinMembers, int height) {
        this(joinMembers, IntStream.range(0, height)
                .mapToObj((i) -> LineFactory.randomCreate(joinMembers.getNumberOfMembers()))
                .collect(Collectors.toList()));
    }

    public Ladder(JoinMembers joinMembers, List<Line> lines) {
        this.joinMembers = joinMembers;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public JoinMembers getJoinMembers() {
        return joinMembers;
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

    public LadderResult getResults(List<String> prizes) {
        LadderResult ladderResult = new LadderResult();
        IntStream.range(0, joinMembers.getNumberOfMembers())
                .forEach(memberIDX -> {
                    int prizeIDX = getResult(memberIDX);
                    ladderResult.addResult(joinMembers.getMember(memberIDX), prizes.get(prizeIDX));
                });
        return ladderResult;
    }
}
