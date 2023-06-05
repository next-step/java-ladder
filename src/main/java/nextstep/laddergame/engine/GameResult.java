package nextstep.laddergame.engine;

import java.util.Map;

public class GameResult {

  private final Map<Member, Prize> resultMap;

  public GameResult(Map<Member, Prize> resultMap) {
    this.resultMap = resultMap;
  }

  public Prize getResultOfMember(Member member) {
    if (!resultMap.containsKey(member)) {
      throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
    }

    return resultMap.get(member);
  }

  public Map<Member, Prize> getResultMap() {
    return resultMap;
  }
}
