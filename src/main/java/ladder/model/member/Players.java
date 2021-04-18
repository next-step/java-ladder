package ladder.model.member;

import ladder.error.InvalidNameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
  private static final String SPLIT_DELIMITER = ",";
  private static final int MINIMUM_NAMES_LENGTH = 2;
  private static final String PLAYERS_LENGTH_EXCEPTION_MESSAGE = "참가자의 수는 최소 2명입니다.";

  private final List<Player> players;

  private Players(List<Player> players) {
    this.players = players;
  }

  public static Players initNames(String names) {
    String[] splittedNames = names.split(SPLIT_DELIMITER);
    checkNamesLength(splittedNames.length);

    List<Player> madePlayers = Arrays.stream(splittedNames)
      .map(name -> new Player(name.trim()))
      .collect(Collectors.toList());
    return new Players(madePlayers);
  }

  private static void checkNamesLength(int length) {
    if (length < MINIMUM_NAMES_LENGTH) {
      throw new InvalidNameException(PLAYERS_LENGTH_EXCEPTION_MESSAGE);
    }
  }

  public Player findSpecificPlayer(int index) {
    return players.get(index);
  }

  public List<Player> specificPlayers() {
    return players;
  }

  public int size() {
    return players.size();
  }

  public boolean isNameContains(Player player) {
    return players.contains(player);
  }

}
