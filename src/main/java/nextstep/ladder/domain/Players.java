package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
  static final int MIN_SIZE = 2;
  private final List<Player> players;

  public Players(String input) {
    this(Stream.of(input.split(","))
            .map(String::trim)
            .map(Player::new)
            .collect(Collectors.toList())
    );
  }

  public Players(List<Player> players) {
    validate(players);
    this.players = players;
  }

  private void validate(List<Player> players) {
    if (players.size() < MIN_SIZE) {
      throw new IllegalArgumentException(String.format("참여자는 %d명 이상이어야 합니다.", MIN_SIZE));
    }
    if (players.stream().distinct().count() != players.size()) {
      throw new IllegalArgumentException("참여자 이름은 중복될 수 없습니다.");
    }
  }

  public String toConsoleOutput() {
    return players.stream()
            .map(Player::toConsoleOutput)
            .collect(Collectors.joining(" "));
  }

  public int size() {
    return players.size();
  }
}
