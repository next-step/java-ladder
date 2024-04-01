package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderHeight;
import ladder.domain.User;
import ladder.domain.strtegy.BooleanRandomLineGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

  private final InputView inputView;
  private final ResultView resultView;

  public LadderGameController(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void start() {
    String[] userNames = inputView.inputNames();
    int height = inputView.inputLadderHeight();

    List<User> users = Arrays.stream(userNames)
        .map(User::new)
        .collect(Collectors.toList());
    LadderGame ladderGame = LadderGame.start(users, new LadderHeight(height), new BooleanRandomLineGenerator());

    resultView.printResult(ladderGame);
  }
}
