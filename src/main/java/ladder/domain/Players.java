package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

  private static final String SEPARATOR = ",";
  private static final int MIN_PLAYER = 2;

  private List<Player> players;

  private Players(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public static Players of(String names) {
    if (names.isEmpty()) {
      throw new IllegalArgumentException("입력이 없습니다.");
    }

    String[] strings = split(names);

    return Arrays.stream(strings)
        .map(String::trim)
        .map(Player::of)
        .collect(collectingAndThen(toList(), Players::new));
  }

  private static String[] split(String names) {
    String[] strings = names.split(SEPARATOR);
    if (strings.length < MIN_PLAYER) {
      throw new IllegalArgumentException("플레이어가 너무 작습니다.");
    }

    return strings;
  }

  int size() {
    return players.size();
  }

  public List<Player> getPlayers() {
    return players;
  }
}
