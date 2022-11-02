package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;

public interface LadderFactory {
    Ladder creatLadder(int height, int countPerson);
}
