package ladder.model.result;

import ladder.model.line.Points;
import ladder.model.member.Players;
import ladder.model.prize.Prizes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class InterimResults {
  private static final int ZERO = 0;
  private static final int ONE = 1;

  private final List<InterimResult> interimResults;

  private InterimResults(List<InterimResult> interimResults) {
    this.interimResults = interimResults;
  }

  public static InterimResults makeInterimResults(int size) {
    List<InterimResult> interimResults = new ArrayList<>();

    IntStream.range(0, size).mapToObj(index -> new InterimResult(index, index)).forEach(interimResults::add);
    return new InterimResults(interimResults);
  }

  public List<InterimResult> interimResults() {
    return interimResults;
  }

  public LadderTotalResults toLadderTotalResult(Players players, Prizes prizes) {
    List<LadderTotalResult> results = new ArrayList<>();

    interimResults.stream()
      .map(interimResult ->
        new LadderTotalResult(
          players.findSpecificPlayer(interimResult.firstIndex()),
          prizes.specificPrizes().get(interimResult.resultIndex()))
      ).forEach(results::add);

    return new LadderTotalResults(Collections.unmodifiableList(results));
  }

  public InterimResults move(Points points) {
    InterimResult firstInterimResult = interimResults.stream()
      .filter(interimResult -> interimResult.resultIndex() == ZERO)
      .findFirst()
      .get();

    interimResults
      .stream()
      .filter(interimResult -> interimResult.firstIndex() == firstInterimResult.firstIndex())
      .forEach(interimResult -> {
        int cursor = points.checkMoveOrStop(interimResult.resultIndex());
        interimResult.move(cursor);
      }
    );

    interimResults
      .stream()
      .filter(interimResult -> interimResult.firstIndex() != firstInterimResult.firstIndex())
      .forEach(interimResult -> {
        int cursor = points.checkMoveOrStop(interimResult.resultIndex() - ONE, interimResult.resultIndex());
        interimResult.move(cursor);
      }
    );
    return this;
  }

}
