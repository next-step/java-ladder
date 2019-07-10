package ladder.view;

import ladder.domain.*;

import java.util.Map;
import java.util.Optional;

public class ResultView {

  private static final String VERTICAL_LINE = "|";
  private static final String HORIZONTAL_LINE = "-----";
  private static final String EMPTY_LINE = "     ";

  public static void view(Players players, Ladder ladder, LadderResults ladderResults) {
    printPlayer(players);
    System.out.println();
    printLine(ladder);
    printResult(ladderResults);
  }

  private static void printResult(LadderResults ladderResults) {
    System.out.println(ladderResults.toString());
  }

  private static void printLine(Ladder lines) {
    lines.getLines().stream()
        .map(Line::getLine)
        .forEach(
            bars -> {
              bars.forEach(bar -> System.out.print(VERTICAL_LINE + drawBar(bar)));
              System.out.println();
            });
  }

  private static void printPlayer(Players players) {
    System.out.print(players.toString());
  }

  private static String drawBar(Boolean bar) {
    return bar ? HORIZONTAL_LINE : EMPTY_LINE;
  }

  public static void resultPlayer(String resultName, Map<Player, LadderResult> ladderResult) {
    Player player = ladderResult.keySet()
        .stream()
        .filter(p -> p.isPlayerName(resultName))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("잘못된 이름입니다."));

    System.out.println(ladderResult.get(player).toString());
  }

  public static void resultAllPlayer(Map<Player, LadderResult> ladderResult) {
    ladderResult
        .forEach((key, value) -> System.out.println(key.toString() + ":" + value.toString()));
  }
}
