package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.Position;
import nextstep.ladder.domain.model.Prize;

public class PrizeSheet {
  private Map<Position, Prize> prizeSheet = new HashMap<>();

  public PrizeSheet(List<String> prizes) {
    IntStream.range(0, prizes.size())
        .forEach(position ->
            prizeSheet.put(Position.at(position), new Prize(prizes.get(position))));
  }

  public Prize checkPrize(Player player) {
    return prizeSheet.get(player.getPosition());
  }

  public ResultSheet produceResult(Players players) {
    List<Prize> prizes = players.getPlayers().stream()
        .map(this::checkPrize)
        .collect(Collectors.toList());

    return new ResultSheet(players, prizes);
  }
}
