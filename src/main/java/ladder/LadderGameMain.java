package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.*;


public class LadderGameMain {

    private static final String ALL_RESULT_MESSAGE = "all";

    public static void main(String[] args){

        String[] playerNames = LadderGameController.getPlayerNames();
        String[] awardNames = LadderGameController.getLadderGameAwards(playerNames.length);
        String ladderMaxHeightValue = LadderGameController.getLadderMaxHeight();

        LadderBuildResult ladderBuildResult = LadderGameController.execute(playerNames, ladderMaxHeightValue);
        Awards awards = LadderGameController.makeAwards(awardNames);

        LadderGameController.showBuildResult(ladderBuildResult, awards);

        ClimbResults climbResult = LadderGameController.climb(ladderBuildResult, awards);

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
