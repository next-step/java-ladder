package ladder.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.PlayResult;
import ladder.PlayResults;

public class LadderPlayResults implements PlayResults {

  List<LadderPlayResult> ladderPlayResults = new ArrayList<>();

  public void add(LadderPlayResult playResult) {
    ladderPlayResults.add(playResult);
  }

  @Override
  public List<PlayResult> results() {
    return Collections.unmodifiableList(ladderPlayResults);
  }
}
