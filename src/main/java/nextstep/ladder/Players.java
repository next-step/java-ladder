package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
  private static final Player ALL_PLAYERS = new Player("all", -1);
  private static final Player NONE_PLAYER = new Player("nobody", -1);

  private final List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
  }

  public int size() {
    return players.size();
  }

  public List<String> nameAsList() {
    return players.stream()
            .map(Player::getName)
            .collect(Collectors.toList());
  }

  public List<Chessmen> chessmenAsList() {
    return players.stream()
            .map(Player::asChessmen)
            .collect(Collectors.toList());
  }

  public Player nameToPlayer(String name) {
    return players.stream()
            .filter(player -> player.match(name))
            .findFirst()
            .orElseGet(() -> name.equals("all") ? ALL_PLAYERS : NONE_PLAYER);
  }

  public boolean isAllPlayers(Player play) {
    return play == ALL_PLAYERS;
  }

  public boolean isIndividual(Player player) {
    return ALL_PLAYERS != player;
  }

  public boolean existPlayer(Player player) {
    return players.contains(player);
  }

  public static Players mapToPlayers(List<String> playerNames) {
    return new Players(
            IntStream.range(0, playerNames.size())
                    .mapToObj(i -> new Player(playerNames.get(i), i))
                    .collect(Collectors.toList()));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Players players1 = (Players) o;
    return Objects.equals(players, players1.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(players);
  }

  @Override
  public String toString() {
    return "Players{" +
            "players=" + players +
            '}';
  }
}
