package ladder.domain;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static ladder.domain.Point.START_INDEX;

public class LadderGame {

  private final Ladder ladder;
  private final LadderResults ladderResults;

  private LadderGame(Ladder ladder, LadderResults ladderResults) {
    this.ladder = ladder;
    this.ladderResults = ladderResults;
  }

  public static LadderGame of(Ladder ladder, LadderResults ladderResults) {
    return new LadderGame(ladder, ladderResults);
  }

  public LadderRewards start(Players players) {
    return LadderRewards.of(
        IntStream.range(START_INDEX, players.size())
        .boxed()
        .collect(toMap(players::getPlayer, this::result)));
  }

  private LadderResult result(int index) {
    return ladderResults.resultValue(ladder.result(index));
  }
}
