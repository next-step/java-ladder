package ladder;

import ladder.application.LadderGame;
import ladder.domain.line.LadderLinePainter;
import ladder.domain.position.PositionLogFactory;
import ladder.view.LadderGameController;

public class Application {

    public static void main(String[] args) {
        LadderLinePainter ladderLinePainter = new LadderLinePainter();
        PositionLogFactory positionLogFactory = new PositionLogFactory();

        LadderGame ladderGame = new LadderGame(ladderLinePainter, positionLogFactory);
        LadderGameController gameController = new LadderGameController(ladderGame);

        gameController.startGame();
    }
}
