package ladder;

public class Application {

    public static void main(String[] args) {
        LadderLinePainter ladderLinePainter = new LadderLinePainter();
        PositionLogFactory positionLogFactory = new PositionLogFactory();

        LadderGame ladderGame = new LadderGame(ladderLinePainter, positionLogFactory);
        LadderGameController gameController = new LadderGameController(ladderGame);

        gameController.startGame();
    }
}
