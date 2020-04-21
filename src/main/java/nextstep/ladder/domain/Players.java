package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

  private List<Player> players;

  private Players(List<Player> players) {
    this.players = players;
  }

  public static Players withNames(List<String> names) {
    return new Players(
        IntStream.range(0, names.size())
            .mapToObj(position -> new Player(names.get(position), position))
            .collect(Collectors.toList())
    );
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void ride(Ladder ladder) {
    players.forEach(player -> player.ride(ladder));
  }

  public ResultSheet produceResult(Ladder ladder, PrizeSheet prizeSheet) {
    throwIfInvalid(prizeSheet);
    this.ride(ladder);

    return new ResultSheet(players, prizeSheet);
  }

  private void throwIfInvalid(PrizeSheet prizeSheet) {
    if (players.size() != prizeSheet.getSize()) {
      throw new IllegalArgumentException("선수의 수와 상의 개수가 같아야합니다.");
    }
  }
}
