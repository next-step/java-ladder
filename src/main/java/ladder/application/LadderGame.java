package ladder.application;

import ladder.domain.line.LadderHeight;
import ladder.domain.line.LadderLinePainter;
import ladder.domain.line.LadderLines;
import ladder.domain.player.Players;
import ladder.domain.position.PositionLogFactory;
import ladder.domain.position.PositionLogs;

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
