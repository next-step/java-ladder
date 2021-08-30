package nextstep.ladder.domain.engine;

import nextstep.ladder.domain.impl.line.LadderLine;

import java.util.List;

public interface LineCreator {

    List<LadderLine> create(int countOfPlayer, int countOfLine);
}
