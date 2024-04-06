package ladder;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.dto.PrizeDto;
import ladder.dto.StatusDto;
import ladder.rowgenerator.RowGeneratorRandom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
  private final Players players;
  private final Ladder ladder;
  private final List<Prize> prizes;
  private final Map<String, Prize> results = new HashMap<>();

  public static LadderGame of(final String playersText, final String maxHeight, final String prizesText) {
    List<String> names = csvParser(playersText);
    return new LadderGame(
            names,
            Ladder.of(Integer.parseInt(maxHeight), names.size() - 1, new RowGeneratorRandom()),
            csvParser(prizesText)
    );
  }

  public LadderGame(final List<String> names, Ladder ladder, final List<String> prizes) {
    this.players = new Players(names.stream()
            .map(Player::of)
            .collect(Collectors.toList()));
    this.ladder = ladder;
    this.prizes = prizes.stream()
            .map(Prize::new)
            .collect(Collectors.toList());
  }

  private static List<String> csvParser(final String text) {
    return Arrays.stream(text.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
  }

  public StatusDto status() {
    return new StatusDto(this.players, this.ladder, this.prizes);
  }

  public void play() {
    IntStream.range(0, this.players.size())
            .forEach(startPosition -> results.put(
                    this.players.nameAt(startPosition),
                    this.prizes.get(this.ladder.finalPosition(startPosition)))
            );
  }

  public Map<String, PrizeDto> results() {
    final Map<String, PrizeDto> results = new HashMap<>();

    this.results.forEach((key, value) -> results.put(key, new PrizeDto(value)));

    return results;
  }
}
