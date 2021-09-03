package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> ladder;

    public Ladder(int ladderHeight, int userCount) {
        RandomMakeStrategy randomMakeStrategy = new RandomMakeStrategy();
        ladder = Stream.generate(() -> new Line(userCount, randomMakeStrategy)).limit(ladderHeight).collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return ladder;
    }


}
