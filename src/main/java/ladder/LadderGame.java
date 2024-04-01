package ladder;

import ladder.domain.Ladders;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.ResultDto;
import ladder.rowgenerator.RowGeneratorRandom;
import ladder.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
  private final Players players;
  private final Ladders ladders;

  public static LadderGame of(final String text, final int maxHeight) {
    return new LadderGame(namesParser(text), maxHeight);
  }

  public LadderGame(final List<String> names, final int maxHeight) {
    this.players = new Players(names.stream()
            .map(Player::of)
            .collect(Collectors.toList()));
    this.ladders = Ladders.of(maxHeight, new RowGeneratorRandom(this.players.size() - 1));
  }

  private static List<String> namesParser(final String text) {
    return List.of(text.replace(" ", "")
            .split(","));
  }

  public ResultDto result() {
    return new ResultDto(this.players, this.ladders);
  }
}
