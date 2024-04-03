package ladder;

import ladder.dto.PrizeDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class Main {
  public static void main(String[] args) {
    LadderGame game = LadderGame.of(InputView.participants(), InputView.maxLadderHeight(), InputView.prizes());
    ResultView.displayStatus(game.status());

    game.play();
    Map<String, PrizeDto> results = game.results();

    String name = "";
    while (isNotEmpty((name = InputView.wantResultOf()))) {
      ResultView.displayResult(results, name);
    }
  }

  public static boolean isNotEmpty(final String text) {
    return text != null && !text.isEmpty();
  }
}
