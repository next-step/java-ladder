package nextstep.ladder.domain;

import java.util.List;

public class LadderResult {
  private final List<String> peopleNames;
  private final List<Line> ladderResults;

  public LadderResult(List<String> peopleNames, List<Line> ladderResults) {
    this.peopleNames = peopleNames;
    this.ladderResults = ladderResults;
  }

  public List<String> getPeopleNames() {
    return peopleNames;
  }

  public List<Line> getLadderResults() {
    return ladderResults;
  }
}
