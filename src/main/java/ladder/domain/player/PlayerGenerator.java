package ladder.domain.player;

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
      throw new IllegalArgumentException("중복된 플레이어가 존재합니다. 플레이어 목록을 확인하세요");
    }
  }
}
