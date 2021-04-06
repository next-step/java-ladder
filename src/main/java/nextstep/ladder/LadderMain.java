package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

  public static void main(String[] args) {
    String[] personNames = InputView.getPersonNames();
    String[] results = InputView.getResult();
    checkInput(personNames, results);
    int height = InputView.getLadderHeight();

    Ladder ladder = Ladder.generate(personNames, height);
    ResultView.printLadderGame(ladder, results);

    String resultName = InputView.getResultName();
    while (!resultName.equals("all")) {
      ResultView.printResult(ladder, results, resultName);
      resultName = InputView.getResultName();
    }
    ResultView.printResult(ladder, results);
  }

  private static void checkInput(String[] personNames, String[] results) {
    if (personNames.length != results.length) {
      throw new IllegalArgumentException();
    }
  }

}
