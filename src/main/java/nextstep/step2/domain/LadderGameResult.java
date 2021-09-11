package nextstep.step2.domain;

import java.util.Map;

public class LadderGameResult {

  private Map<Participant, String> ladderGameResultMap;

  LadderGameResult(Map<Participant, String> ladderGameResultMap) {
    this.ladderGameResultMap = ladderGameResultMap;
  }

  public String getLadderGameResult(Participant participant) {
    return ladderGameResultMap.get(participant);
  }

  public int getLadderGameResultMapSize() {
    return ladderGameResultMap.size();
  }
}
