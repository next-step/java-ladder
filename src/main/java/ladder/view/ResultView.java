package ladder.view;

import java.util.stream.Collectors;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.Line;
import ladder.domain.Point;

public class ResultView {

  private static final String SEPARATOR = System.lineSeparator();
  private static final String VERTICAL = "|";
  private static final String CONNECT = "-----";
  private static final String DISCONNECT = "     ";

  public static void showPlayers(Players players) {
    System.out.println(SEPARATOR + "사다리 결과" + SEPARATOR);
    players.names().stream()
        .map(name -> String.format("%6s", name.getName()))
        .forEach(System.out::print);
    System.out.println();
  }

  public static void showLadder(Ladder ladder, Results results) {
    ladder.lines().stream()
        .map(line -> DISCONNECT + showLine(line) + SEPARATOR)
        .forEach(System.out::print);

    results.result().stream()
        .map(result -> String.format("%6s", result.getResult()))
        .forEach(System.out::print);
    System.out.println();
  }

  private static String showLine(Line line) {
    return line.points().stream()
        .map(point -> VERTICAL + hasPedal(point))
        .collect(Collectors.joining());
  }

  private static String hasPedal(Point point) {
    return point.isRight() ? CONNECT : DISCONNECT;
  }

  public static void showResultOfPerson(Results results, String name) {
    System.out.println(SEPARATOR + "실행 결과");
    System.out.println(results.findOne(name));
  }

  public static void showResultAll(Results results) {
    System.out.println(SEPARATOR + "실행 결과");
    results.gameResult().entrySet()
        .stream()
        .map(e -> String.format("%s : %s", e.getKey().getName(), e.getValue().getResult()))
        .forEach(System.out::println);
  }
}
