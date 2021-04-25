package ladder.view;

import ladder.domain.Depth;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {
  private static final String EXECUTE_RESULT = "실행결과";
  private static final String PLAYER_NAME_SEPARATOR = "    ";
  private static final String LINE_SEPARATOR = "|";
  private static final String DEPTH_LINES_FORMAT = LINE_SEPARATOR + "%s" + LINE_SEPARATOR;
  private static final String LINE_EXISTS = "--------";
  private static final String LINE_EMPTY = "        ";

  private ResultView() {
  }

  public static void print(Players playersParam, Ladder ladderParam) {
    System.out.println(EXECUTE_RESULT);
    System.out.println(playerNames(playersParam));
    ladder(ladderParam).forEach(System.out::println);
  }

  private static String playerNames(Players players) {
    return players.getValues()
            .stream()
            .map(Player::name)
            .collect(Collectors.joining(PLAYER_NAME_SEPARATOR));
  }

  private static List<String> ladder(Ladder ladder) {
    return ladder.getDepth()
            .stream()
            .map(ResultView::depth)
            .collect(Collectors.toList());
  }

  private static String depth(Depth depth) {
    String lines = depth.getValues().stream()
            .map(ResultView::line)
            .collect(Collectors.joining(LINE_SEPARATOR));
    return String.format(DEPTH_LINES_FORMAT, lines);
  }

  private static String line(Line line) {
    return line.isEmpty() ? LINE_EMPTY : LINE_EXISTS;
  }
}
