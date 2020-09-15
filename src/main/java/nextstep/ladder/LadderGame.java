package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.JudgeLadderResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.playLadderGame();
    }

    private void playLadderGame() {
        Users users = Users.create(inputView.inputParticipateUsers());
        Rewards rewards = Rewards.create(inputView.inputResultReward());
        LadderHeight ladderHeight = LadderHeight.create(inputView.inputLadderHeight());

        Ladder ladder = Ladder.create(users,ladderHeight);

        JudgeLadderResult judgeLadderResult = JudgeLadderResult.newInstance(ladder, users);

        resultView.showLadderResult(users, ladder, rewards);

        showResultProcess(judgeLadderResult, rewards);
    }

    private void showResultProcess(JudgeLadderResult judgeLadderResult , Rewards rewards) {
        boolean isShowOneUser = true;
        while(isShowOneUser) {
            String targetUser = inputView.inputShowResultTarget();
            isShowOneUser = resultLoop(targetUser);

            LadderResultBoard resultBoard = judgeLadderResult.judge(isShowOneUser, targetUser);

            resultView.showLadderGameResult(resultBoard,rewards);
        }
    }

    private boolean resultLoop(String targetUser) {
        if(targetUser.equals("all")) {
            return false;
        }
        return true;
    }

}
