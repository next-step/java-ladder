package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;

public interface LadderFactory {
    Ladder createLadder(int height, int countPerson);
}
