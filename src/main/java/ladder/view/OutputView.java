package ladder.view;

import java.util.Map;
import ladder.LadderDisplay;
import ladder.Player;

public class OutputView {

  public static final String RESULT_INTRO_WORD = "실행 결과";

  public static void printPlayersName(String playersName) {
    System.out.println(playersName);
  }

  public static void printLadder(LadderDisplay ladder) {
    ladder.draw().stream()
        .forEach(System.out::print);
  }

  public static void printLadderResults(String results) {
    System.out.println(results);
  }

  public static void printAllPlayerResult(Map<Player, String> gameResult) {
    System.out.println(RESULT_INTRO_WORD);
    gameResult.forEach((player, result) -> System.out.println(player.getName() + " : " + result));
  }

  public static void printSoloResult(String gameResult) {
    System.out.println(RESULT_INTRO_WORD);
    System.out.println(gameResult);
  }
}
