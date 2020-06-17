package nextstep.ladder.domain.game;

import nextstep.ladder.domain.vo.Point;

import java.util.Map;

public class LadderGameSnapshots {
    private final Map<Point, LadderGameSnapshot> results;

    public LadderGameSnapshots(final Map<Point, LadderGameSnapshot> ladderResult) {
        this.results = ladderResult;
    }
}
