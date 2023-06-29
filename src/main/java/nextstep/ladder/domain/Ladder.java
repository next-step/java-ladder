package nextstep.ladder.domain;

import java.util.Map;

public class Ladder {
  private Map<LadderPoint, LadderBarStatus> ladderBarStatuses;
  private int ladderLength;

  public Ladder(Map<LadderPoint, LadderBarStatus> ladderBarStatuses, int ladderLength) {
    this.ladderBarStatuses = ladderBarStatuses;
    this.ladderLength = ladderLength;
  }

  public Map<LadderPoint, LadderBarStatus> getLadderBarStatuses() {
    return this.ladderBarStatuses;
  }

  public int getLadderLength() {
    return this.ladderLength;
  }
}