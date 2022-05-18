package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(int theNumberOfLines, int countOfParticipants) {
        List<Line> init = IntStream.range(0, theNumberOfLines)
                .mapToObj(i -> Line.from(countOfParticipants))
                .collect(Collectors.toList());
        return new Ladder(init);
    }

    public List<Line> getLines() {
        return List.copyOf(lines); // 방어적 복사
    }
}
