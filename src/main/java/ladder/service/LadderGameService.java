package ladder.service;

import ladder.domain.*;
import ladder.dto.PrizeDto;
import ladder.dto.StatusDto;
import ladder.rowgenerator.RowGeneratorRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameService {
  private final ThreadLocal<Ladder> threadLocal = new ThreadLocal<>();

  public StatusDto status(final List<String> names, final int maxHeight, final List<String> prizeTexts) {
    Ladder ladder = Ladder.of(maxHeight, names.size() - 1, new RowGeneratorRandom());
    threadLocal.set(ladder);

    return new StatusDto(names, ladder, prizeTexts);
  }

  public Map<String, PrizeDto> play(final List<String> names, final int maxHeight, final List<String> prizeTexts) {
    final Map<String, PrizeDto> results = new HashMap<>();

    Players players = Players.from(names);

    Ladder ladder = threadLocal.get();
    threadLocal.remove();

    Prizes prizes = new Prizes(prizeTexts.stream()
            .map(Prize::new)
            .collect(Collectors.toList()));

    for (Player player : players) {
      Coordinates lastPosition = player.move(ladder);
      results.put(player.name(), new PrizeDto(prizes.prizeAt(lastPosition.x())));
    }

    return results;
  }

  private List<Player> createPlayers(List<String> names) {
    return IntStream.range(0, names.size())
            .mapToObj(index -> Player.of(names.get(index), index))
            .collect(Collectors.toList());
  }
}
