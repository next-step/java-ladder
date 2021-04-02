package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Point;

public class ResultView {

  public static void showPlayers(Players players) {
    System.out.println("\n실행 결과\n");
    players.names().stream()
        .map(name -> String.format("%6s", name.getName()))
        .forEach(System.out::print);
    System.out.println();
  }

  public static void showLadder(Ladder ladder) {
    ladder.lines().forEach(line -> {
      line.points().stream()
          .map(Point::pedal)
          .forEach(System.out::print);
      System.out.println();
    });
  }
}
