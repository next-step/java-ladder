package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder generateLadder(int userCount, int height) {
        return Ladder.of(IntStream.range(0, height)
            .mapToObj(idx -> Line.generateLine(userCount))
            .collect(Collectors.toList()));
    }

    public int size(){
        return this.lines.size();
    }
}
