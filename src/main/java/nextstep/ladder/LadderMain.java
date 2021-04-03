package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

  public static void main(String[] args) {
    String[] personNames = InputView.getPersonNames();
    int height = InputView.getLadderHeight();
    Ladder ladder = Ladder.generate(personNames, height);
    ResultView.printResult(ladder);
  }

}
