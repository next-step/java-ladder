package ladder;

import ladder.view.InputView;
import ladder.view.PrintView;

public class LadderGamePlayer {

    public void play(Ladder ladder, Rewards rewards) {
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
        if ("exit".equals(resultName)) {
            return true;
        }
        return false;
    }

    private void printResult(Ladder ladder, Rewards rewards, String resultName) {
        if ("all".equals(resultName)) {
            PrintView.printAllResult(ladder, rewards);
            return;
        }

        if ("exit".equals(resultName)) {
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
