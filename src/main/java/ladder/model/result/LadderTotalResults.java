package ladder.model.result;

import ladder.error.NotFoundResultException;
import ladder.model.member.Player;

import java.util.List;

public class LadderTotalResults {
  private static final String RESULT_NOT_FOUND_MESSAGE = "결과를 찾을 수 없습니다.";

  private final List<LadderTotalResult> results;

  public LadderTotalResults(List<LadderTotalResult> results) {
    this.results = results;
  }

  public List<LadderTotalResult> results() {
    return results;
  }

  public LadderTotalResult findByPlayer(Player player) {
    return results.stream()
      .filter(ladderTotalResult -> ladderTotalResult.player().equals(player))
      .findAny()
      .orElseThrow(() -> new NotFoundResultException(RESULT_NOT_FOUND_MESSAGE));
  }

}
