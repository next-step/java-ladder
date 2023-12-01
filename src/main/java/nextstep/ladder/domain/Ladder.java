package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder makeLadder(int participatorCount, int height) {
        List<Line> lines = IntStream.range(0, height).boxed()
                .map(num -> Line.makeLine(participatorCount, () -> new Random().nextBoolean()))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public void play(Participator participator) {
        lines.forEach(line -> line.go(participator));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
