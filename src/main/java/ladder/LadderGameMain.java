package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.Award;
import ladder.domain.Awards;
import ladder.domain.LadderBuildResult;
import ladder.domain.Player;

import java.util.LinkedHashMap;
import java.util.Map;


public class LadderGameMain {

    private static final String ALL_RESULT_MESSAGE = "all";

    public static void main(String[] args){

        String[] playerNames = LadderGameController.getPlayerNames();
        String[] awardNames = LadderGameController.getLadderGameAwards(playerNames.length);
        String ladderMaxHeightValue = LadderGameController.getLadderMaxHeight();

        LadderBuildResult ladderBuildResult = LadderGameController.execute(playerNames, ladderMaxHeightValue);
        Awards awards = LadderGameController.makeAwards(awardNames);

        LadderGameController.showBuildResult(ladderBuildResult, awards);

        LinkedHashMap<Player, Award> climbResult = LadderGameController.climb(ladderBuildResult, awards);

        String playerName = LadderGameController.getPlayerResult();

        while(true){

            LadderGameController.showPlayerResult(climbResult, playerName);

            if(playerName.equals(ALL_RESULT_MESSAGE)){
                break;
            }

            playerName = LadderGameController.getPlayerResult();
        }

    }
}
