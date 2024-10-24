package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int memberSize, int height, CreateStrategy createStrategy) {
        this(IntStream.range(0, height)
                .mapToObj(num -> new Line(memberSize, createStrategy))
                .collect(Collectors.toList()));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int getSize() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public LadderResult playLadders(Members members, Rewords rewords) {
        validateToPlay(members, rewords);
        Points points = movePoints(members);
        return LadderResult.of(points, members, rewords);
    }

    private Points movePoints(Members members) {
        return lines.stream()
                .reduce(new Points(members.getSize()), Points::move, (p1, p2) -> p2);
    }

    private static void validateToPlay(Members members, Rewords rewords) {
        if (members.getSize() != rewords.getSize()) {
            throw new IllegalStateException("사다리 게임을 진행할 수 없습니다.");
        }
    }
}
