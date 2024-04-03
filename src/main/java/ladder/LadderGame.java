package ladder;

import ladder.domain.*;
import ladder.rowgenerator.RowGeneratorRandom;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
  private final Players players;
  private final Ladders ladders;
  private final List<Prize> prizes;

  public static LadderGame of(final String playersText, final String maxHeight, final String prizesText) {
    return new LadderGame(csvParser(playersText), Integer.parseInt(maxHeight), csvParser(prizesText));
  }

  public LadderGame(final List<String> names, final int maxHeight, final List<String> prizes) {
    this.players = new Players(names.stream()
            .map(Player::of)
            .collect(Collectors.toList()));
    this.ladders = Ladders.of(maxHeight, new RowGeneratorRandom(this.players.size() - 1));
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
}
