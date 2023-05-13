package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerGenerator {

  public List<Player> generatePlayerList(List<String> players) {
    final Set<Player> playerSet = players.stream()
        .map(Player::new)
        .collect(Collectors.toSet());


    if (playerSet.size() != players.size()) {
      throw new LadderGameException(ExceptionCode.DUPLICATE_PLAYER_IN_GAME);
    }

    return new ArrayList<>(playerSet);
  }
}
