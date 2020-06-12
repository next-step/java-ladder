package ladder;

public class Application {

    public static void main(String[] args) {
        LadderLinePainter ladderLinePainter = new LadderLinePainter();
        LadderGame ladderGame = new LadderGame(ladderLinePainter);
        LadderGameController gameController = new LadderGameController(ladderGame);
        gameController.startGame();
    }
}
