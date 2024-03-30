package ladder;

import ladder.domain.Ladders;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.rowgenerator.RowGeneratorRandom;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<String> names = namesParser(InputView.participants());
    Players players = new Players(names.stream()
            .map(Player::of)
            .collect(Collectors.toList()));
    Ladders ladders = Ladders.of(InputView.maxLadderHeight(), new RowGeneratorRandom(names.size() - 1));
    ResultView.displayResult(players, ladders);
  }

  private static List<String> namesParser(final String text) {
    return List.of(text.replace(" ", "")
            .split(","));
  }
}
