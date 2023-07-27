package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {

  private final List<PlayerName> playerNames;

  public PlayerNames(List<PlayerName> playerNames) {
    this.playerNames = playerNames;
  }

  public PlayerNames(String[] playerNames) {
    this(Arrays.stream(playerNames)
        .map(PlayerName::new)
        .collect(Collectors.toList()));
  }

  public PlayerName get(int index) {
    return this.playerNames.get(index);
  }

  public int size() {
    return this.playerNames.size();
  }
}
