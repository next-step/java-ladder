package ladder;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Players {

  public static final String PLAYERS_NAME_DELIMITER = ",";
  List<Player> players;

  public Players(String playersName) {
    if (isBlank(playersName)) {
      throw new IllegalArgumentException("players 이름을 입력하세요");
    }
    players = initPlayers(playersName);

  }

  private boolean isBlank(String playersName) {
    return playersName == null || "".equals(playersName.trim());
  }

  private List<Player> initPlayers(String playersName) {
    String[] splitNames = splitPlayersName(playersName);
    checkPlayersCount(splitNames);
    return Arrays.stream(splitNames)
        .map(Player::new)
        .collect(toList());
  }

  private String[] splitPlayersName(String playersName) {
    return playersName.split(PLAYERS_NAME_DELIMITER);
  }

  private void checkPlayersCount(String[] splitNames) {
    if (splitNames.length < 2) {
      throw new IllegalArgumentException("player 는 최소 2명입니다.");
    }
  }

  public int count() {
    return players.size();
  }

  public int maxNameLength() {
    return players.stream()
        .map(Player::nameLength)
        .max(Comparator.comparingInt(Integer::intValue))
        .orElse(0);
  }

  public String getLengthFormatPlayersName(int length) {
    StringBuffer playersName = new StringBuffer();
    for (Player player : players) {
      playersName.append(player.nameFormat(length));
    }
    return playersName.toString();
  }
}
