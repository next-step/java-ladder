package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.impl.board.LadderBoardCreator;
import nextstep.ladder.domain.engine.BoardCreator;
import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.domain.impl.line.RandomLineCreator;

public class LadderFactoryBean {

    public static BoardCreator createLadderFactory() {
        LineCreator lineCreator = new RandomLineCreator();
        return new LadderBoardCreator(lineCreator);
    }
}
