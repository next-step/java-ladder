package ladder;

import ladder.domain.*;
import ladder.rowgenerator.RowGeneratorRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
  private final Players players;
  private final Ladders ladders;
  private final List<Prize> prizes;
  private Map<String, Prize> results = new HashMap<>();

  public static LadderGame of(final String playersText, final String maxHeight, final String prizesText) {
    List<String> names = csvParser(playersText);
    return new LadderGame(names,
            Ladders.of(Integer.parseInt(maxHeight), new RowGeneratorRandom(names.size() - 1)),
            csvParser(prizesText));
  }

  public LadderGame(final List<String> names, Ladders ladders, final List<String> prizes) {
    this.players = new Players(names.stream()
            .map(Player::of)
            .collect(Collectors.toList()));
    this.ladders = ladders;
    this.prizes = prizes.stream()
            .map(Prize::new)
            .collect(Collectors.toList());
  }

  private static List<String> csvParser(final String text) {
    return List.of(text.replace(" ", "")
            .split(","));
  }

  public StatusDto status() {
    return new StatusDto(this.players, this.ladders, this.prizes);
  }

  public void play() {
    IntStream.range(0, this.players.size())
            .forEach(i -> {
              int position = i;
              for (Row row : this.ladders) {
                position = row.nextPosition(position);
              }
              results.put(this.players.at(i).name(), this.prizes.get(position));
            });
  }

  public Map<String, Prize> result() {
    return this.results;
  }
}
