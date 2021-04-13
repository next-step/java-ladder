package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

  public static void main(String[] args) {
    final People people = getPeople();
    final List<Result> results = getResults(people.personCount());
    final LadderHeight ladderHeight = getLadderHeight();

    final Ladder ladder = new Ladder(people, ladderHeight, new RandomLineCreationStrategy());
    ResultView.printLadder(ladder);
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
}
