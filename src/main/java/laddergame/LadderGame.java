package laddergame;

import java.util.Map;
import java.util.Scanner;
import laddergame.model.Ladder;
import laddergame.model.LadderResultPositions;
import laddergame.model.Name;
import laddergame.model.Names;
import laddergame.model.PositiveNumber;
import laddergame.view.LadderGameView;

public class LadderGame {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LadderGameView.printInputPlayerNamesMsg();
    Names players = Names.createByNameStrArr(scanner.nextLine().split(","));

    LadderGameView.printInputResultNamesMsg();
    Names results = Names.createByNameStrArrWithLength(
        scanner.nextLine().split(","), players.getCountOfNames());

    LadderGameView.printInputLadderHeightMsg();
    PositiveNumber ladderHeight = new PositiveNumber(scanner.nextInt());
    scanner.nextLine();

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(ladderHeight, players.getCountOfNames());

    LadderGameView.printLadder(players, ladder, results);

    LadderResultPositions resultPositions = LadderResultPositions
        .createByLadderWithCountOfPerson(ladder, players.getCountOfNames());

    Map<Name, Name> resultMap = resultPositions.getMapOf(players, results);

    while (true) {
      LadderGameView.printInputResultOfPlayerMsg();
      LadderGameView.printResult(resultMap, new Name(scanner.nextLine()));
    }


  }
}
