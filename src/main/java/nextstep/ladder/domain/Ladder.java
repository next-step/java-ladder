package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
