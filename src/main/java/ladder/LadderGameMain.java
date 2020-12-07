package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.Award;
import ladder.domain.Awards;
import ladder.domain.LadderBuildResult;
import ladder.domain.Player;

import java.util.List;
import java.util.Map;

public class LadderGameMain {

    public static void main(String[] args){

        String[] playerNames = LadderGameController.getPlayerNames();
        String[] awardNames = LadderGameController.getLadderGameAwards(playerNames.length);
        String ladderMaxHeightValue = LadderGameController.getLadderMaxHeight();

        LadderBuildResult ladderBuildResult = LadderGameController.execute(playerNames, ladderMaxHeightValue);
        Awards awards = LadderGameController.makeAwards(awardNames);

        LadderGameController.showBuildResult(ladderBuildResult, awards);

    }
}
