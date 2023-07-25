package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ladder {
  private final LadderPoints ladderPoints;
  public Ladder(LadderPoints ladderPoints) {
    this.ladderPoints = ladderPoints;
  }

  public MatchingResult play() {
    PlayerStatuses playerStatuses = new PlayerStatuses(this.ladderPoints);
    MatchingResult matchingResult = new MatchingResult();

    List<PlayerStatus> results = playerStatuses.go();

    for (int i = 0; i < results.size(); i++) {
      matchingResult.add(i, results.get(i).getLocation().getX());
    }

    return matchingResult;
  }
}