package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int theNumberOfLines, int countOfParticipants, LineStrategy lineStrategy) {
        List<Line> init = IntStream.range(0, theNumberOfLines)
                .mapToObj(i -> Line.of(countOfParticipants, lineStrategy))
                .collect(Collectors.toList());
        return new Ladder(init);
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return List.copyOf(lines); // 방어적 복사
    }
}
