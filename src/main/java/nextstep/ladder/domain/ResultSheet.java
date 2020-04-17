package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nextstep.ladder.domain.model.Prize;

public class ResultSheet {
  private static final String RESULT_FORMAT = "%s : %s";

  private Map<String, Prize> resultSheet = new HashMap<>();

  public ResultSheet(List<Player> players, PrizeSheet prizeSheet) {
    writeResultSheet(prizeSheet, players);
  }

  private void writeResultSheet(PrizeSheet prizeSheet, List<Player> players) {
    players.forEach(player ->
        resultSheet.put(player.getName(), prizeSheet.get(player.getPosition())));
  }

  public void print() {
    resultSheet.forEach((name, prize) -> System.out.println(
        String.format(RESULT_FORMAT, name, prize.getPrize())
    ));
  }

  public Prize checkResult(String name) {
    if (!resultSheet.containsKey(name)) {
      throw new IllegalArgumentException("해당 이름을 가진 사람이 존재하지 않습니다.");
    }

    return resultSheet.get(name);
  }
}
