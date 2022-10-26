package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineTestUtil {

    static LadderLine createNoneLadderLine(int width) {
        return new LadderLine(IntStream.range(0, width)
                .mapToObj(i -> Ladder.NONE)
                .collect(Collectors.toList()));
    }

    static LadderLine continuousLadder() {
        return new LadderLine(List.of(Ladder.RIGHT, Ladder.LEFT));
    }
}
