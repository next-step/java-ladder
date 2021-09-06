package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private List<LadderLine> lines;

    public Ladder(int countOfPerson, Height height) {
        this.lines = new ArrayList<>();
        IntStream.range(0, height.value())
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
