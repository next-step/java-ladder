package laddergame;

import laddergame.model.Ladder;
import laddergame.model.LadderResultMapper;
import laddergame.model.Name;
import laddergame.model.PlayerNames;
import laddergame.model.PositiveNumber;
import laddergame.model.ResultNames;
import laddergame.view.LadderGameInput;
import laddergame.view.LadderGameView;

public class LadderGame {

  private final static Name NAME_FOR_END = new Name("all");

  public static void main(String[] args) {
    String[] playerNames = LadderGameInput.getPlayerNamesInputWithPrintMsg();
    PlayerNames players = PlayerNames.createBy(playerNames);

    String[] resultNames = LadderGameInput.getResultNamesInputWithPrintMsg();
    ResultNames results = ResultNames.createByNamesWithLength(resultNames, players.getCountOfNames());

    PositiveNumber ladderHeight = new PositiveNumber(LadderGameInput.getHeightInputWithPrintMsg());

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(ladderHeight, players.getCountOfNames());

    LadderGameView.printLadder(players, ladder, results);

    LadderResultMapper ladderResultMapper = LadderResultMapper.createBy(ladder, players, results);

    for (Name playerForResult = new Name(LadderGameInput.getPlayerForResultInputWithPrintMsg());
        !playerForResult.equals(NAME_FOR_END);
        playerForResult = new Name(LadderGameInput.getPlayerForResultInputWithPrintMsg())) {
      LadderGameView.printResultOf(ladderResultMapper, playerForResult);
    }

    LadderGameView.printResultOfAll(ladderResultMapper);
  }
}
