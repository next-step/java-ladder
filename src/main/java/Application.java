import controller.LadderController;
import domain.strategy.RandomHorizontalLineDrawingStrategy;
import view.LadderInputView;

public class Application {

  public static void main(String[] args) {
    LadderController ladderController = new LadderController();

    String names = LadderInputView.inputNames();
    int ladderHeight = LadderInputView.inputLadderHeight();
    RandomHorizontalLineDrawingStrategy strategy = new RandomHorizontalLineDrawingStrategy();
    ladderController.startGame(names, ladderHeight, strategy);
  }

}
