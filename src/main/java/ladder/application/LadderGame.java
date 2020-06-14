package ladder.application;

import ladder.domain.*;

public class LadderGame {

    private final LadderLinePainter ladderLinePainter;
    private final PositionLogFactory positionLogFactory;

    public LadderGame(LadderLinePainter ladderLinePainter,
                      PositionLogFactory positionLogFactory) {
        this.ladderLinePainter = ladderLinePainter;
        this.positionLogFactory = positionLogFactory;
    }

    public LadderLines start(Players players, LadderHeight ladderHeight) {
        return ladderLinePainter.drawLines(players, ladderHeight);
    }

    public PositionLogs play(Players players, LadderLines ladderLines) {
        PositionLogs positionLogs = positionLogFactory.createBy(players.size());
        positionLogs.moveDown(ladderLines);
        return positionLogs;
    }
}
