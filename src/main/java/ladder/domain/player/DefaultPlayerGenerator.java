package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ladder.domain.ladder.player.LadderGamePlayerInfo;

public class DefaultPlayerGenerator implements PlayerGenerator {

  private static final int MIN_PLAYER_REQUIRED_CNT = 2;

  @Override
  public LadderGamePlayerInfo generatePlayerList(List<String> players) {
    if (MIN_PLAYER_REQUIRED_CNT > players.size()) {
      throw new LadderGameException(ExceptionCode.MIN_PLAYER_COUNT_REQUIRED);
    }

    final Set<Player> playerSet = players.stream()
        .map(Player::new)
        .collect(Collectors.toSet());


    if (playerSet.size() != players.size()) {
      throw new LadderGameException(ExceptionCode.DUPLICATE_PLAYER_IN_GAME);
    }

    return new LadderGamePlayerInfo(playerSet);
  }
}
