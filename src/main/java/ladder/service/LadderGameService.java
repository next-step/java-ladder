package ladder.service;

import ladder.domain.*;
import ladder.dto.PrizeDto;
import ladder.dto.StatusDto;
import ladder.rowgenerator.RowGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameService {
  private final ThreadLocal<Ladder> threadLocal = new ThreadLocal<>();

  public void setLadder(final int width, final int maxHeight, RowGenerator rowGenerator) {
    Ladder ladder = Ladder.of(maxHeight, width, rowGenerator);
    threadLocal.set(ladder);
  }

  public StatusDto status(final List<String> names, final List<String> prizeTexts) {
    Ladder ladder = threadLocal.get();
    return new StatusDto(names, ladder, prizeTexts);
  }

  public Map<String, PrizeDto> play(final List<String> names, final List<String> prizeTexts) {
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
}
