package nextstep.ladder.engine;

import nextstep.ladder.codeleesh.domain.Ladder;

public interface LadderCreator {

    Ladder create(final int countOfPerson, final int height);
}
