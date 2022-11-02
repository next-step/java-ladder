package ladder.testutil;

import ladder.domain.ladder.direction.HorizontalLineDirection;
import ladder.domain.ladder.direction.MoveHorizontalDirection;
import ladder.domain.ladder.LadderLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineTestUtil {

    public static LadderLine createNoneLadderLine(int width) {
        return new LadderLine(IntStream.range(0, width)
                .mapToObj(i -> new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE))
                .collect(Collectors.toList()));
    }

    public static LadderLine continuousLadder() {
        return new LadderLine(List.of(
                new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT),
                new MoveHorizontalDirection(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT)
        ));
    }
}
