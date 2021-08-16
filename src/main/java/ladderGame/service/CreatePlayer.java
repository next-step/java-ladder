package ladderGame.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ladderGame.model.Player;

public class CreatePlayer {

  private static final String SPLIT_MARK = ",";

  public static List<Player> createUser(final String players) {
    return createNewPlayers(splitNames(players));
  }

  private static List<Player> createNewPlayers(final List<String> players) {
    return players.stream()
        .distinct()
        .map(Player::new)
        .collect(Collectors.toList());
  }

  private static List<String> splitNames(final String players) {
    return Arrays.asList(players.split(SPLIT_MARK));
  }
}
