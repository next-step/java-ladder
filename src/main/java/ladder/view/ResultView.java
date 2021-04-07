package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Point;
import ladder.domain.Results;

public class ResultView {

  public static void showPlayers(Players players) {
    System.out.println(System.lineSeparator() + "사다리 결과" + System.lineSeparator());
    players.names().stream()
        .map(name -> String.format("%6s", name.getName()))
        .forEach(System.out::print);
    System.out.println();
  }

  public static void showLadder(Ladder ladder, Results results) {
    ladder.lines().forEach(line -> {
      line.points().stream()
          .map(Point::pedal)
          .forEach(System.out::print);
      System.out.println();
    });

    results.result().stream()
        .map(result -> String.format("%6s", result.getResult()))
        .forEach(System.out::print);
    System.out.println();
  }

  public static void showResultOfPerson(Results results, String name) {
    System.out.println(System.lineSeparator() + "실행 결과");
    System.out.println(results.findOne(name));
  }

  public static void showResultAll(Results results) {
    System.out.println(System.lineSeparator() + "실행 결과");
    results.gameResult().entrySet()
        .stream()
        .map(e -> String.format("%s : %s", e.getKey().getName(), e.getValue().getResult()))
        .forEach(System.out::println);
  }
}
