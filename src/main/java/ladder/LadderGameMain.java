package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.LadderGameResult;

public class LadderGameMain {

    public static void main(String[] args){

        String[] playerNames = LadderGameController.getPlayerNames();
        String[] awards = LadderGameController.getLadderGameAwards(playerNames.length);
        String ladderMaxHeightValue = LadderGameController.getLadderMaxHeight();

        LadderGameResult ladderGameResult = LadderGameController.execute(playerNames, ladderMaxHeightValue);

        LadderGameController.showResult(ladderGameResult);

    }
}
