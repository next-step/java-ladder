package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static ladder.domain.Point.START_INDEX;

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

    AtomicInteger index = new AtomicInteger(START_INDEX);
    return Arrays.stream(strings)
        .map(name -> Player.of(name, index.getAndIncrement()))
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

  public Players move(Line line) {
    return players.stream()
        .map(player -> player.move(line))
        .collect(collectingAndThen(toList(), Players::new));
  }

  public Map<Player, LadderResult> gameResults(LadderResults ladderResults) {
    return players.stream()
        .collect(toMap(identity(), p -> p.gameResult(ladderResults)));
  }

  @Override
  public String toString() {
    return players.stream()
        .map(Player::toString)
        .collect(joining(" "));
  }

}
