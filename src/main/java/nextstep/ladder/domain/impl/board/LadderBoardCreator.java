package nextstep.ladder.domain.impl.board;

import nextstep.ladder.domain.engine.Board;
import nextstep.ladder.domain.engine.BoardCreator;
import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.domain.impl.line.LadderLine;

import java.util.List;

public class LadderBoardCreator implements BoardCreator {

    private LineCreator lineCreator;

    public LadderBoardCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Board create(int countOfPlayer, int countOfLine) {
        List<LadderLine> lines = lineCreator.create(countOfPlayer, countOfLine);
        return LadderBoard.from(lines);
    }
}
