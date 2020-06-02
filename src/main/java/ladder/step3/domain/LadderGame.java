package ladder.step3.domain;

import java.util.Map;

public class LadderGame {

  private final Map<Participant, LadderResult> resultMap;

  private LadderGame (Map<Participant, LadderResult> resultMap) {
    this.resultMap = resultMap;
  }

  public static LadderGame of (Map<Participant, LadderResult> resultMap) {
    return new LadderGame(resultMap);
  }

  public LadderResult getResult (Participant participant) {
    validate(participant);
    return resultMap.get(participant);
  }

  public LadderResult getResult (String participant) {
    return getResult(Participant.valueOf(participant));
  }

  private void validate (Participant participant) {
    if (resultMap.get(participant) == null) {
      throw new IllegalArgumentException("참여자에 포함된 사람이 아닙니다.");
    }
  }
}
