package ladder.domain.ladder;

import ladder.domain.util.RightPointRandom;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> lines;

    public Ladder(int countOfPlayer, int ladderSize, RightPointRandom rightPointRandom) {
        this.lines = IntStream.range(0, ladderSize)
                .mapToObj(i -> new Line(countOfPlayer, rightPointRandom))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
