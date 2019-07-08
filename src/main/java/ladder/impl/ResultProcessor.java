package ladder.impl;

import java.util.List;
import ladder.PlayResult;
import ladder.PlayResults;

public class ResultProcessor {

  private final Players players;
  private final Targets targets;

  public ResultProcessor(Players players, Targets targets) {
    this.players = players;
    this.targets = targets;
  }

  public static ResultProcessor of(Players players, Targets targets) {
    return new ResultProcessor(players, targets);
  }

  public LadderGameResult toResults(PlayResults playResults) {
    LadderGameResult ladderGameResult = new LadderGameResult();
    List<PlayResult> results = playResults.results();
    for (PlayResult playResult : results) {
      ladderGameResult.add(players.getName(playResult.playerPosition()),
          targets.getTarget(playResult.targetPosition()));
    }
    return ladderGameResult;
  }

}
