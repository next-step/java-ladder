package ladderGame.step3.view;

import java.util.List;
import java.util.stream.Collectors;
import ladderGame.step3.model.Ladder;

public class ResultView {

  private static final String STRING_FORMAT_SIZE = "%6s";

  private static final String HAVING_CONNECTION = "-----|";

  private static final String NONE_CONNECTION = "|";

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
}