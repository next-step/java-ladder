package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;

public abstract class LadderFactory {
    public abstract Ladder createLadder(int ladderCount, int maxHeight, LineGenerator lineGenerator);
}
