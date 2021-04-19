package ladder.model.result;

import ladder.model.member.Players;
import ladder.model.prize.Prizes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InterimResults {
  List<InterimResult> interimResults;

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

}
