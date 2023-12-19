package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final JoinMembers joinMembers;
    private final List<Line> lines;

    public Ladder(JoinMembers joinMembers, int height) {
        this(joinMembers, IntStream.range(0, height)
                .mapToObj((i) -> new Line(joinMembers.getNumberOfMembers() - 1))
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
}
