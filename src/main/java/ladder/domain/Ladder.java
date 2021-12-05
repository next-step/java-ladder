package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(Names names, Height height) {
        this.ladder = Collections.unmodifiableList(ladderLine(names, height));
    }

    public List<Line> ladderLine(Names names, Height height) {
        int namesCount = names.size();
        int ladderHeight = height.value();
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.from(namesCount))
                .collect(Collectors.toList());
    }

    public Line findLine(int index) {
        return ladder.get(index);
    }

    public int size() {
        return ladder.size();
    }
}
