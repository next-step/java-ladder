package laddergame;

import laddergame.model.Ladder;
import laddergame.model.LadderResultMapper;
import laddergame.model.PlayerName;
import laddergame.model.PlayerNames;
import laddergame.model.PositiveNumber;
import laddergame.model.ResultNames;
import laddergame.view.LadderGameInput;
import laddergame.view.LadderGameView;

public class LadderGame {

  private final static PlayerName NAME_FOR_END = PlayerName.createBy("all");

  public static void main(String[] args) {
    String[] playerNames = LadderGameInput.getPlayerNamesInputWithPrintMsg();
    PlayerNames players = PlayerNames.createBy(playerNames);

    String[] resultNames = LadderGameInput.getResultNamesInputWithPrintMsg();
    ResultNames results = ResultNames.createByNamesWithLength(resultNames, players.getCountOfNames());

    PositiveNumber ladderHeight = new PositiveNumber(LadderGameInput.getHeightInputWithPrintMsg());

    Ladder ladder = Ladder.createByHeightAndCountOfPerson2(ladderHeight, players.getCountOfNames());

    LadderGameView.printLadder2(players, ladder, results);

    LadderResultMapper ladderResultMapper = LadderResultMapper.createBy(ladder, players, results);

    for (PlayerName playerForResult = PlayerName.createBy(LadderGameInput.getPlayerForResultInputWithPrintMsg());
        !playerForResult.equals(NAME_FOR_END);
        playerForResult = PlayerName.createBy(LadderGameInput.getPlayerForResultInputWithPrintMsg())) {
      LadderGameView.printResultOf(ladderResultMapper, playerForResult);
    }

    LadderGameView.printResultOfAll(ladderResultMapper);
  }
}
