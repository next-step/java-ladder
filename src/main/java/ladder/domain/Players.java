package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Players {

  static final String SEPARATOR = ",";
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

  public int size() {
    return players.size();
  }

  @Override
  public String toString() {
    return players.stream()
        .map(Player::toString)
        .collect(joining(" "));
  }

}
