package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private static final int LADDER_MIN_COUNT = 1;
    private List<LadderLine> lines;

    public Ladder(int countOfPerson, int height) {
        if (height < LADDER_MIN_COUNT) {
            throw new IllegalArgumentException("사다리 높이는 최소 " + LADDER_MIN_COUNT + "가 되어야 합니다.");
        }
        this.lines = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(index -> lines.add(LadderLine.init(countOfPerson)));
    }

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public int move(int index) {
        for (LadderLine line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public int size() {
        return lines.size();
    }

    public Stream<LadderLine> stream() {
        return lines.stream();
    }
}
