package nextstep.ladder;

import nextstep.ladder.domain.LadderMatcher;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

  public static void main(String[] args) {
    String[] personNames = InputView.getNames();
    Persons persons = Persons.generate(personNames);

    String[] resultNames = InputView.getResults();
    Results results = Results.generate(resultNames);

    int ladderHeight = InputView.getLadderHeight();
    LadderMatcher ladderMatcher = LadderMatcher.generate(persons, results, ladderHeight);
    ResultView.printLadderGame(ladderMatcher);

    String startName = InputView.getStartName();
    while (!startName.equals("all")) {
      ResultView.printLadderResult(ladderMatcher, startName);
      startName = InputView.getStartName();
    }
    ResultView.printLadderResults(ladderMatcher);
  }

}
