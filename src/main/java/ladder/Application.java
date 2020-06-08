package ladder;

public class Application {

    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController(new LadderGame());
        gameController.startGame();
    }
}
