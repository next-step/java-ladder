package ladderGame.step4.view;

import java.util.List;
import java.util.stream.Collectors;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Prizes;

public class ResultView {

  private static final String STRING_FORMAT_SIZE = "%6s";

  private static final String HAVING_CONNECTION = "-----|";

  private static final String NONE_CONNECTION = "|";

  private static final String RESULT_FORM = " : ";

  private ResultView() {
  }

  public static void printUsersName(final List<String> players) {
    System.out.println(players
        .stream()
        .map(name -> String.format(STRING_FORMAT_SIZE, name))
        .collect(Collectors.joining()));
  }

  public static void printLadder(final Ladder ladder) {
    ladder.ladderValues()
        .forEach(ResultView::printLinView);
  }

  private static void printLinView(final List<Boolean> list) {
    StringBuilder sb = new StringBuilder();
    list.stream()
        .map(ResultView::formatLadder)
        .forEach(sb::append);
    System.out.println(sb);
  }

  public static String formatLadder(boolean point) {
    if (point) {
      return String.format(STRING_FORMAT_SIZE, HAVING_CONNECTION);
    }
    return String.format(STRING_FORMAT_SIZE, NONE_CONNECTION);
  }

  public static void printPrizes(final Prizes prizes) {

    System.out.println(prizes.prizeNames()
        .stream()
        .map(prize -> String.format(STRING_FORMAT_SIZE, prize))
        .collect(Collectors.joining()));
  }

  public static void printResult(
      final List<MatchResult> matchResults,
      final Prizes prizes) {

    System.out.println("실행 결과");

    for (MatchResult matchResult : matchResults) {

      String playerName = matchResult.getPlayerName();
      String prize = prizes.prizeNames().get(matchResult.getIndex());

      System.out.println(playerName + RESULT_FORM + prize);
    }
  }
}