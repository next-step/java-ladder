package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Row> rows;

    private Ladder(LadderInitInfo ladderInitInfo) {
        rows = Stream.generate(() -> Row.init(ladderInitInfo))
                .limit(ladderInitInfo.getLadderHeight())
                .collect(Collectors.toList());
    }

    public static Object init(LadderInitInfo ladderInitInfo) {
        return new Ladder(ladderInitInfo);
    }
}
