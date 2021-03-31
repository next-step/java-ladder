package ladder;

import java.util.List;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView ResultView = new ResultView();

    List<String> names = inputView.inputNames();
    int height = inputView.inputHeight();

    LadderGame ladderGame = new LadderGame(height, names);

  }
}
