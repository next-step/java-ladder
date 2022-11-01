package ladder;

import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.view.InputView;
import ladder.view.PrintView;

public class LadderGamePlayer {

    private static final String RESULT_ALL_COMMAND = "all";
    private static final String LOOP_EXIT_COMMAND = "exit";

    public void play(LadderGameData gameData) {
        Ladder ladder = gameData.getLadder();
        Rewards rewards = gameData.getRewards();

        PrintView.printLadder(ladder, rewards);
        InputView.clear();

        Boolean flag = false;
        while (!flag) {
            String resultName = InputView.getResultName();
            printResult(ladder, rewards, resultName);

            flag = updateFlag(resultName);
        }
    }

    private boolean updateFlag(String resultName) {
        return LOOP_EXIT_COMMAND.equals(resultName);
    }

    private void printResult(Ladder ladder, Rewards rewards, String resultName) {
        if (RESULT_ALL_COMMAND.equals(resultName)) {
            PrintView.printAllResult(ladder, rewards);
            return;
        }

        if (LOOP_EXIT_COMMAND.equals(resultName)) {
            return;
        }

        try {
            PrintView.printResult(rewards.getReward(ladder.getEndPoint(resultName)));
        } catch (Exception e) {
            printTryAgain(e);
        }
    }

    private void printTryAgain(Exception e) {
        PrintView.printError(e);
    }

}
