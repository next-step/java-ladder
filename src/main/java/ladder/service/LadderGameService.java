package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prize;
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

  public StatusDto status(final List<String> names, final Integer maxHeight, final List<String> prizeTexts) {
    Ladder ladder = Ladder.of(maxHeight, names.size() - 1, new RowGeneratorRandom());
    threadLocal.set(ladder);

    return new StatusDto(names, ladder, prizeTexts);
  }

  public Map<String, PrizeDto> play(final List<String> names, final Integer maxHeight, final List<String> prizeTexts) {
    final Map<String, PrizeDto> results = new HashMap<>();

    Players players = new Players(IntStream.range(0, names.size())
            .mapToObj(index -> Player.of(names.get(index), index))
            .collect(Collectors.toList()));

    Ladder ladder = threadLocal.get();
    threadLocal.remove();

    List<Prize> prizes = prizeTexts.stream()
            .map(Prize::new)
            .collect(Collectors.toList());

    IntStream.range(0, players.size())
            .forEach(startPosition -> results.put(
                    players.nameAt(startPosition),
                    new PrizeDto(prizes.get(ladder.finalPosition(startPosition))))
            );

    return results;
  }
}
