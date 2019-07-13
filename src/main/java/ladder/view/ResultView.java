package ladder.view;

import ladder.domain.*;

import java.util.List;

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
        .forEach(ResultView::printBars);
  }

  private static void printBars(List<Boolean> bars) {
    bars.forEach(bar -> System.out.print(VERTICAL_LINE + drawBar(bar)));
    System.out.println();
  }

  private static void printPlayer(Players players) {
    System.out.print(players.toString());
  }

  private static String drawBar(boolean bar) {
    return bar ? HORIZONTAL_LINE : EMPTY_LINE;
  }

  public static void resultPlayer(String resultName, LadderRewards ladderRewards) {
    System.out.println(ladderRewards.searchPlayer(resultName));
  }

  public static void resultAllPlayer(LadderRewards ladderRewards) {
    ladderRewards.allPlayer()
        .forEach(System.out::println);
  }
}
