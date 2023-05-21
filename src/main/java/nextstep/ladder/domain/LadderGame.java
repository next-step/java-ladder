package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private List<Line> lines;

    public static LadderHeight readLadderHeight(int height) {
        return new LadderHeight(height);
    }

    private LadderGame(LadderHeight ladderHeight, int ladderWeight) {
        lines = IntStream.range(0, ladderHeight.height())
                .mapToObj(i -> drawLine(ladderWeight))
                .collect(Collectors.toList());
    }

    private Line drawLine(int ladderWidth) {
        return new Line(ladderWidth);
    }

    public static LadderGame create(LadderHeight ladderHeight, int countOfPerson) {
        return new LadderGame(ladderHeight, countOfPerson);
    }

    public List<Line> toList() {
        return Collections.unmodifiableList(lines);
    }

}
