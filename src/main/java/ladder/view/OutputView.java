package ladder.view;

import ladder.LadderDisplay;

public class OutputView {

  public static void printPlayersName(String playersName) {
    System.out.println(playersName);
  }

  public static void printLadder(LadderDisplay ladder) {
    ladder.draw().stream()
        .forEach(System.out::print);
  }

}
