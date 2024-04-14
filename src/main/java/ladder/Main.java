package ladder;

import ladder.dto.PrizeDto;
import ladder.rowgenerator.RowGeneratorRandom;
import ladder.service.LadderGameService;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    LadderGameService game = new LadderGameService();

    List<String> playerNames = csvParser(InputView.participants());
    int height = Integer.parseInt(InputView.maxLadderHeight());
    List<String> prizes = csvParser(InputView.prizes());

    game.setLadder(playerNames.size() - 1, height, new RowGeneratorRandom());

    ResultView.displayStatus(game.status(playerNames, prizes));

    Map<String, PrizeDto> results = game.play(playerNames, prizes);

    String name = "";
    while (isNotEmpty((name = InputView.wantResultOf()))) {
      ResultView.displayResult(results, name);
    }
  }

  private static boolean isNotEmpty(final String text) {
    return text != null && !text.isEmpty();
  }

  private static List<String> csvParser(final String text) {
    return Arrays.stream(text.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
  }
}
