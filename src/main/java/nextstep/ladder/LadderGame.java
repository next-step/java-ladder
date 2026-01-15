package nextstep.ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Rewards;

public class LadderGame {
  private final Ladder ladder;
  private final Rewards rewards;

  public LadderGame(Ladder ladder, Rewards rewards) {
    this.ladder = ladder;
    this.rewards = rewards;
  }

  public LadderGameResult play(Participants participants) {
    Map<String, String> results = new HashMap<>();
    IntStream.range(0, participants.size())
        .forEach(i -> {
          results.put(participants.getNameAt(i), rewards.getRewardAt(ladder.findEnd(i)));
        });
    return new LadderGameResult(results);
  }

}
