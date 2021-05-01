package ladder.view;

import ladder.domain.Depth;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Record;
import ladder.domain.Result;

import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {
  private static final String LADDER_RESULT = "사다리 결과";
  private static final String EXECUTE_RESULT = "실행 결과";
  private static final String SEPARATOR = "    ";
  private static final String LINE_SEPARATOR = "|";
  private static final String DEPTH_LINES_FORMAT = LINE_SEPARATOR + "%s" + LINE_SEPARATOR;
  private static final String LINE_EXISTS = "--------";
  private static final String LINE_EMPTY = "        ";
  private static final String EXECUTE_RESULT_FIND_ALL_FORMAT = "%s : %s";

  private ResultView() {
  }

  public static void print(Players playersParam, Ladder ladderParam, Result resultParam) {
    System.out.println(LADDER_RESULT);
    System.out.println(playerNames(playersParam));
    ladder(ladderParam).forEach(System.out::println);
    System.out.println(getResultString(resultParam));
  }

  private static String getResultString(Result result) {
    return result.getValues()
            .stream()
            .collect(Collectors.joining(SEPARATOR));
  }

  private static String playerNames(Players players) {
    return players.getValues()
            .stream()
            .map(Player::name)
            .collect(Collectors.joining(SEPARATOR));
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

  public static void printResultByKeyword(final Players players, final Record record, final Result result, final String keyword, final boolean isFindAll) {
    System.out.println(EXECUTE_RESULT);
    findResultByKeyword(players, record, result, keyword, isFindAll)
            .forEach(System.out::println);
  }

  private static List<String> findResultByKeyword(final Players players, final Record record, final Result result, final String keyword, final boolean isFindAll) {
    return players.getValues().stream()
            .filter(player -> isFindAll || player.equals(Player.create(keyword)))
            .map(player -> getResultToString(result, record, player, isFindAll))
            .collect(Collectors.toList());
  }

  private static String getResultToString(final Result result, final Record record, final Player player, final boolean isUseFindAllFormat) {
    String resultToString = result.get(record, player);
    if (isUseFindAllFormat) {
      return String.format(EXECUTE_RESULT_FIND_ALL_FORMAT, player.name(), resultToString);
    }

    return resultToString;
  }
}
