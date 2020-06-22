package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class FixedLadderGenerator implements LadderGenerator {

    @Override
    public List<Line> generate() {
        return Arrays.asList(
                new Line(Arrays.asList(false, true, false, true)),
                new Line(Arrays.asList(false, false, true, false)),
                new Line(Arrays.asList(false, true, false, false)),
                new Line(Arrays.asList(false, false, true, false)),
                new Line(Arrays.asList(false, true, false, true)));
    }
}
