package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Player;
import ladder.domain.Players;

public class ResultView {

  private static final String VERTICAL_LINE = "|";
  private static final String HORIZONTAL_LINE = "-----";
  private static final String EMPTY_LINE = "     ";

  public static void view(Players players, Lines lines) {
    printPlayer(players);
    System.out.println();
    printLine(lines);
  }

  private static void printLine(Lines lines) {
    lines.getLines().stream()
        .map(Line::getLine)
        .forEach(
            bars -> {
              bars.stream()
                  .forEach(bar -> System.out.print(VERTICAL_LINE + drawBar(bar)));
              System.out.println(VERTICAL_LINE);
            });
  }

  private static void printPlayer(Players players) {
    players.getPlayers().forEach(System.out::print);
  }

  private static String drawBar(Boolean bar) {
    return bar ? HORIZONTAL_LINE : EMPTY_LINE;
  }
}
