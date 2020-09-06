package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.util.JudgeLadderResult;
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

        LadderGenerator ladderGenerator = LadderGenerator.create(users, ladderHeight);
        Ladder ladder = ladderGenerator.make();

        JudgeLadderResult judgeLadderResult = JudgeLadderResult.newInstance(ladder, users);
        LadderPositionBoard ladderPositionBoard = judgeLadderResult.judge();

        resultView.showLadderResult(users, ladder, rewards);

        showResultProcess(ladderPositionBoard, rewards);
    }

    private void showResultProcess(LadderPositionBoard ladderPositionBoard, Rewards rewards) {
        LadderRewardBoard ladderRewardBoard = LadderRewardBoard.create(ladderPositionBoard, rewards);

        while(true) {
            String targetUser = inputView.inputShowResultTarget();

            String rewardResult = ladderRewardBoard.showUserReward(targetUser);
            resultView.showLadderGameResult(rewardResult);
        }
    }
}
