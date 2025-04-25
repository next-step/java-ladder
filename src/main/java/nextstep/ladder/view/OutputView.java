package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

import java.util.Map;

public class OutputView {
  public static final int SPACE_WIDTH = 5;

  public static void printLadder(Players players, Ladder ladder) {
    System.out.println("실행 결과\n");
    System.out.println(players.toConsoleOutput());
    System.out.println(ladder.toConsoleOutput());
    System.out.println(ladder.resultsOutput());
  }

  public static void printAllResult(Map<Player, String> allResults) {
    System.out.println("실행 결과");
    allResults.forEach((player, result) -> System.out.printf("%s : %s%n", player.toConsoleOutput(), result));
  }

  public static void printResult(String result) {
    System.out.println("실행 결과");
    System.out.println(result);
  }
}
