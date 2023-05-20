package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.player.LadderGamePlayerInfo;

public class DefaultPlayerGenerator implements PlayerGenerator {

  private static final int MIN_PLAYER_REQUIRED_CNT = 2;

  @Override
  public LadderGamePlayerInfo generatePlayerList(List<String> playerNames) {
    int playerSize = playerNames.size();

    if (MIN_PLAYER_REQUIRED_CNT > playerSize) {
      throw new LadderGameException(ExceptionCode.MIN_PLAYER_COUNT_REQUIRED);
    }

    final int distinctPlayerCnt = (int) playerNames.stream()
        .distinct()
        .count();

    if (distinctPlayerCnt != playerSize) {
      throw new LadderGameException(ExceptionCode.DUPLICATE_PLAYER_IN_GAME);
    }

    List<Player> playerList = new ArrayList<>(playerSize);
    for (int i = 0; i < playerSize; i++) {
      playerList.add(new Player(playerNames.get(i), i));
    }

    return new LadderGamePlayerInfo(playerList);
  }
}
