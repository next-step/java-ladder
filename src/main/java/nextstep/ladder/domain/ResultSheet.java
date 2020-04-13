package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.Name;
import nextstep.ladder.domain.model.Prize;

public class ResultSheet {
  private Map<Name, Prize> resultSheet = new HashMap<>();

  public ResultSheet(Players players, List<Prize> prizes) {
    List<Player> playerList = players.getPlayers();
    if (playerList.size() != prizes.size()) {
      throw new IllegalArgumentException("선수의 수와 상의 개수가 같아야합니다.");
    }

    IntStream.range(0, prizes.size())
        .forEach(index -> {
          Player player = playerList.get(index);
          resultSheet.put(player.getName(), prizes.get(index));
        });
  }
}
