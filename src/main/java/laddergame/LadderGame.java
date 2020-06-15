package laddergame;

import java.util.Scanner;
import laddergame.model.Ladder;
import laddergame.model.Names;
import laddergame.model.PositiveNumber;
import laddergame.view.LadderGameView;

public class LadderGame {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LadderGameView.printInputNameMsg();
    Names names = Names.createByNameStrArr(scanner.nextLine().split(","));

    LadderGameView.printInputLadderHeightMsg();
    PositiveNumber ladderHeight = new PositiveNumber(scanner.nextInt());
    scanner.nextLine();

    LadderGameView
        .printResult(names, Ladder.createByHeightAndCountOfPerson(ladderHeight, names.getCountOfNames()));
  }
}
