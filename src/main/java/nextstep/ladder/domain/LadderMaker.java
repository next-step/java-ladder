package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMaker {
    private final LineMaker lineMaker;

    public LadderMaker(LineMaker lineMaker) {
        this.lineMaker = lineMaker;
    }

    public Ladder makeLadder(int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> lineMaker.makeLine())
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

}
