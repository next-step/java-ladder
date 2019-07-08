package ladder.view;


import java.util.Map;
import ladder.Ladder;
import ladder.impl.Players;
import ladder.impl.Targets;

public class OutputView {

  public static final String RESULT_INTRO_WORD = "실행 결과";
  public static final String RESULT_LADDER_INTRO_WORD = "사다리결과";

  public static void printLadderResultIntro() {
    printBlankLIne();
    System.out.println(RESULT_LADDER_INTRO_WORD);
    printBlankLIne();
  }

  private static void printBlankLIne() {
    System.out.println();
  }

  public static void printPlayersName(Players players) {
    System.out.println(players.toString());
  }

  public static void printLadder(Ladder ladder) {
    System.out.println(ladder.toString());
  }

  public static void printTargets(Targets targets) {
    System.out.println(targets.toString());
  }

  public static void printAllPlayerResult(Map<String, String> gameResult) {
    System.out.println(RESULT_INTRO_WORD);
    gameResult.forEach((player, result) -> System.out.println(player + " : " + result));
  }

  public static void printSoloResult(String gameResult) {
    System.out.println(RESULT_INTRO_WORD);
    System.out.println(gameResult);
  }

}
