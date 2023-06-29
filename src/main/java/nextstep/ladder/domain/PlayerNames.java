package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerNames {

  Set<PlayerName> playerNames;

  public PlayerNames(Set<PlayerName> playerNames) {
    this.playerNames = playerNames;
  }

  // 생성자에 로직이 들어갔는데 괜찮은지?
  public PlayerNames(String[] playerNames) {
    this(Arrays.stream(playerNames)
        .map(PlayerName::new)
        .collect(Collectors.toSet()));
  }

  public Set<PlayerName> getPlayerNames() {
    return new HashSet<>(playerNames);
  }

  public int size() {
    return playerNames.size();
  }
}
