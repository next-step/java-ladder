package ladderGame.step2.view;

import ladderGame.step2.model.Lines;
import ladderGame.step2.model.Players;

public class PrintView {

  public static void printUsersName(final Players players) {
    printResultTitle();
    System.out.println(Players.createUsersNameView(players));
  }

  private static void printResultTitle() {
    System.out.println();
    System.out.println("실행결과");
    System.out.println();
  }

  public static void printLadderView(final Lines lines) {
    Lines.createLadderView(lines)
        .forEach(System.out::println);
  }

}