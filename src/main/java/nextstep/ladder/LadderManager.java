package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.GameResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.RandomLineCreationStrategy;
import nextstep.ladder.domain.Result;
import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.SizeNotMatchingException;
import nextstep.ladder.io.InputView;
import nextstep.ladder.io.ResultView;

public final class LadderManager {

  public static final String ALL = "all";

  public static void main(String[] args) {
    final People people = getPeople();
    final List<Result> results = getResults(people.personCount());
    final LadderHeight ladderHeight = getLadderHeight();

    final Ladder ladder = new Ladder(ladderHeight, new RandomLineCreationStrategy(), people.personCount());
    ResultView.printLadder(ladder, people);
    ResultView.printResults(results);

    final GameResults gameResults = ladder.gameResults(people, results);

    String name = InputView.inputPersonNameForResult();
    while (!ALL.equals(name)) {
      final Result result = getResult(gameResults, name);

      ResultView.printResult(result);
      name = InputView.inputPersonNameForResult();
    }
    ResultView.printGameResults(people, gameResults);
  }

  private static People getPeople() {
    try {
      return People.from(InputView.inputNames());
    } catch (LadderException e) {
      System.err.println(e.getMessage());
      return getPeople();
    }
  }

  private static List<Result> getResults(int personCount) {
    try {
      final List<Result> results = Arrays.stream(InputView.inputResults())
          .map(Result::new)
          .collect(Collectors.toList());

      validateSize(personCount, results);

      return results;
    } catch (LadderException e) {
      System.err.println(e.getMessage());
      return getResults(personCount);
    }
  }

  private static void validateSize(int personCount, List<Result> results) {
    if (personCount != results.size()) {
      throw new SizeNotMatchingException();
    }
  }

  private static LadderHeight getLadderHeight() {
    try {
      return new LadderHeight(InputView.inputLadderHeight());
    } catch (LadderException e) {
      System.err.println(e.getMessage());
      return getLadderHeight();
    }
  }

  private static Result getResult(GameResults gameResults, String name) {
    try {
      return gameResults.resultOf(name);
    } catch (LadderException e) {
      System.err.println(e.getMessage());
      return getResult(gameResults, InputView.inputPersonNameForResult());
    }
  }
}
