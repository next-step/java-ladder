package ladderGame.step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

  private static final String SPLIT_MARK = ",";

  private final List<Player> players;

  public Players(final List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public int count(){
    return players.size();
  }

  public List<Player> toList() {
    return new ArrayList<>(players);
  }

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