package nextstep.ladder;

import java.util.Map;
import nextstep.ladder.domain.Ladder;
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

    LadderMatcher ladderMatcher = LadderMatcher.generate(persons, results);

    int ladderHeight = InputView.getLadderHeight();
    Ladder ladder = Ladder.generate(persons.size(), ladderHeight);
    ResultView.printLadderGame(ladderMatcher, ladder);
    Map<String, String> moveResult = ladderMatcher.getMoveResult(ladder);

    String startName = InputView.getStartName();
    while (!startName.equals("all")) {
      ResultView.printLadderResult(moveResult, startName);
      startName = InputView.getStartName();
    }
    ResultView.printLadderResults(moveResult);
  }

}
