package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;

    private Ladder(LadderHeight ladderHeight, int ladderWeight) {
        lines = IntStream.range(0, ladderHeight.height())
                .mapToObj(i -> drawLine(ladderWeight))
                .collect(Collectors.toList());
    }

    private Line drawLine(int ladderWidth) {
        return new Line(ladderWidth);
    }

    public static Ladder create(LadderHeight ladderHeight, int countOfPerson) {
        return new Ladder(ladderHeight, countOfPerson);
    }

    public List<Line> toList(){
        return Collections.unmodifiableList(lines);
    }

}
