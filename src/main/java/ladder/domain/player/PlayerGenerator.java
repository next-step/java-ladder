package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerGenerator {

  public List<Player> generatePlayerList(List<String> players) {
    throwIfDuplicatePlayerFound(players);
    return players.stream()
        .map(Player::new)
        .collect(Collectors.toList());
  }

  private void throwIfDuplicatePlayerFound(List<String> players) {
    long distinctPlayerCnt = players.stream()
        .distinct()
        .count();

    if (distinctPlayerCnt != players.size()) {
      throw new LadderGameException(ExceptionCode.DUPLICATE_PLAYER_IN_GAME);
    }
  }
}
