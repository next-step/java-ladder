package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.Award;
import ladder.domain.Awards;
import ladder.domain.LadderBuildResult;
import ladder.domain.Player;

import java.util.Map;

import static ladder.domain.LadderGameConfig.ALL_RESULT_MESSAGE;

public class LadderGameMain {

    public static void main(String[] args){

        String[] playerNames = LadderGameController.getPlayerNames();
        String[] awardNames = LadderGameController.getLadderGameAwards(playerNames.length);
        String ladderMaxHeightValue = LadderGameController.getLadderMaxHeight();

        LadderBuildResult ladderBuildResult = LadderGameController.execute(playerNames, ladderMaxHeightValue);
        Awards awards = LadderGameController.makeAwards(awardNames);

        LadderGameController.showBuildResult(ladderBuildResult, awards);

        Map<Player, Award> climbResult = LadderGameController.climb(ladderBuildResult, awards);

        String playerName = LadderGameController.getPlayerResult();

        while(true){

            if(playerName.equals(ALL_RESULT_MESSAGE)){
                LadderGameController.showPlayerResult(climbResult, playerName);
                break;
            }

            LadderGameController.showPlayerResult(climbResult, playerName);
            playerName = LadderGameController.getPlayerResult();
        }

    }
}
