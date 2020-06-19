package laddergame;

import laddergame.model.Ladder;
import laddergame.model.LadderResultMapper;
import laddergame.model.Name;
import laddergame.model.Names;
import laddergame.model.PositiveNumber;
import laddergame.view.LadderGameInput;
import laddergame.view.LadderGameView;

public class LadderGame {

  private final static Name NAME_FOR_END = new Name("all");

  public static void main(String[] args) {
    String[] playerNames = LadderGameInput.getPlayerNamesInputWithPrintMsg();
    Names players = Names.createBy(playerNames);

    String[] resultNames = LadderGameInput.getResultNamesInputWithPrintMsg();
    Names results = Names.createByNamesWithLength(resultNames, players.getCountOfNames());

    PositiveNumber ladderHeight = new PositiveNumber(LadderGameInput.getHeightInputWithPrintMsg());

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(ladderHeight, players.getCountOfNames());

    LadderGameView.printLadder(players, ladder, results);

    LadderResultMapper ladderResultMapper = LadderResultMapper.createBy(ladder, players, results);

    while (true) {
      Name playerForResult = new Name(LadderGameInput.getPlayerForResultInputWithPrintMsg());
      LadderGameView.printResult(ladderResultMapper, playerForResult);

      if (playerForResult.equals(NAME_FOR_END)) {
        break;
      }
    }
  }
}
