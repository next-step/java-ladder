package ladder.testutil;

import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.LadderLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineTestUtil {

    public static LadderLine createNoneLadderLine(int width) {
        return new LadderLine(IntStream.range(0, width)
                .mapToObj(i -> HorizontalLineDirection.STRAIGHT).collect(Collectors.toList()));
    }

    public static LadderLine continuousLadder() {
        return new LadderLine(List.of(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT));
    }
}
