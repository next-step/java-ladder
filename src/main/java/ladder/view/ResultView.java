package ladder.view;

import ladder.domain.Line;
import ladder.domain.Ladder;
import ladder.domain.Players;

public class ResultView {

  private static final String VERTICAL_LINE = "|";
  private static final String HORIZONTAL_LINE = "-----";
  private static final String EMPTY_LINE = "     ";

  public static void view(Players players, Ladder ladder) {
    printPlayer(players);
    System.out.println();
    printLine(ladder);
  }

  private static void printLine(Ladder lines) {
    lines.getLines().stream()
        .map(Line::getLine)
        .forEach(
            bars -> {
              bars.forEach(bar -> System.out.print(VERTICAL_LINE + drawBar(bar)));
              System.out.println(VERTICAL_LINE);
            });
  }

  private static void printPlayer(Players players) {
    System.out.println(players.toString());
  }

  private static String drawBar(Boolean bar) {
    return bar ? HORIZONTAL_LINE : EMPTY_LINE;
  }
}
