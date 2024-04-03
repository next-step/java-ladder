import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new LadderController(new InputView(), new OutputView()).run();
    }
}
