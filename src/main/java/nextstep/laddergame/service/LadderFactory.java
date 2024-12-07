package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
@FunctionalInterface
public interface LadderFactory {
    Ladder createLadder(int ladderCount, int maxHeight, LineGenerator lineGenerator);
}
