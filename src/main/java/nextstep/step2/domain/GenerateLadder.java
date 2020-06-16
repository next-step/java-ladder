package nextstep.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateLadder {
    private List<Line> ladder;

    public GenerateLadder(int userCount, int ladderHeightCount) {
        ladder = Stream.generate(() -> new Line(userCount))
                .limit(ladderHeightCount)
                .collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
