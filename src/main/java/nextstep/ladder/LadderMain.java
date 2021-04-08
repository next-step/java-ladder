package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

  private static final String ALL = "all";

  public static void main(String[] args) {
    String[] personNames = InputView.getPersonNames();
    String[] results = InputView.getResult();
    int height = InputView.getLadderHeight();
    Ladder ladder = Ladder.generate(personNames, height, results);
    ResultView.printLadderGame(ladder, results);

    String personName = InputView.getResultPersonName();
    while (!personName.equals(ALL)) {
      ResultView.printResult(ladder, personName);
      personName = InputView.getResultPersonName();
    }
    ResultView.printResult(ladder);
  }

}
