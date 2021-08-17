package ladderGame.step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

  public static final String MSG_ERROR_LIMIT_PLAYERS = "플레이어가 0명입니다.";

  private static final String SPLIT_MARK = ",";

  private final List<Player> players;

  public Players(final List<Player> players) {
    validationPlayersCount(players);
    this.players = Collections.unmodifiableList(players);
  }

  private void validationPlayersCount(final List<Player> players) {
    if(players.isEmpty()){
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_PLAYERS);
    }
  }

  public int count(){
    return players.size();
  }

  public static String createUsersNameView(final Players players) {
    return players.players
        .stream()
        .map(Player::findUserName)
        .collect(Collectors.joining());
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