package laddergame;

import java.util.Scanner;
import laddergame.model.Ladder;
import laddergame.model.Players;
import laddergame.model.PositiveNumber;
import laddergame.view.LadderGameView;

public class LadderGame {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LadderGameView.printInputNameMsg();
    Players players = Players.createByNameStrArr(scanner.nextLine().split(","));

    LadderGameView.printInputLadderHeightMsg();
    PositiveNumber ladderHeight = new PositiveNumber(scanner.nextInt());
    scanner.nextLine();

    LadderGameView
        .printResult(players, Ladder.createByHeightAndCountOfPerson(ladderHeight, players.getCountOfPerson()));
  }
}
