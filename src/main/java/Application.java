import ladder.controller.GameController;
import ladder.controller.LadderGameController;

public class Application {
    public static void main(String[] args) {
        GameController controller = LadderGameController.of();
        controller.startGame();
    }
}
