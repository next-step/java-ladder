package laddergame;

import java.util.Map;
import laddergame.model.Ladder;
import laddergame.model.LadderResultPositions;
import laddergame.model.Name;
import laddergame.model.Names;
import laddergame.model.PositiveNumber;
import laddergame.view.LadderGameInput;
import laddergame.view.LadderGameView;

public class LadderGame {

  public static void main(String[] args) {
    String[] playerNames = LadderGameInput.getPlayerNamesInputWithPrintMsg();
    Names players = Names.createBy(playerNames);

    String[] resultNames = LadderGameInput.getResultNamesInputWithPrintMsg();
    Names results = Names.createByNamesWithLength(resultNames, players.getCountOfNames());

    PositiveNumber ladderHeight = new PositiveNumber(LadderGameInput.getHeightInputWithPrintMsg());

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(ladderHeight, players.getCountOfNames());

    LadderGameView.printLadder(players, ladder, results);

    LadderResultPositions resultPositions = LadderResultPositions
        .createByLadderWithCountOfPerson(ladder, players.getCountOfNames());
    Map<Name, Name> resultMap = resultPositions.getMapOf(players, results);

    while (true) {
      Name resultOfPlayer = new Name(LadderGameInput.getResultOfPlayerInputWithPrintMsg());
      LadderGameView.printResult(resultMap, resultOfPlayer);
    }


  }
}
