package laddergame;

import java.util.Scanner;
import laddergame.model.Height;
import laddergame.model.Ladder;
import laddergame.view.LadderGameView;

public class LadderGame {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LadderGameView.printInputNameMsg();
    String[] nameStrArr = scanner.nextLine().split(",");

    LadderGameView.printInputLadderHeightMsg();
    Height ladderHeight = new Height(scanner.nextInt());
    scanner.nextLine();

    LadderGameView
        .printResult(Ladder.createByHeightAndNamesStrArr(ladderHeight, nameStrArr));
  }
}
