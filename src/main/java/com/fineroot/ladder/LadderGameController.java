package com.fineroot.ladder;

import com.fineroot.ladder.domain.LadderGame;
import com.fineroot.ladder.domain.LadderGameResult;
import com.fineroot.ladder.domain.Rewards;
import com.fineroot.ladder.domain.User;
import com.fineroot.ladder.domain.UserRewardSet;
import com.fineroot.ladder.domain.Users;
import com.fineroot.ladder.factory.LadderFactoryBean;
import com.fineroot.ladder.view.InputView;
import com.fineroot.ladder.view.ResultView;
import com.fineroot.ladder.viewmodel.InputViewModel;
import com.fineroot.ladder.viewmodel.ResultViewModel;

public class LadderGameController {

    private final InputViewModel inputViewModel;
    private final ResultViewModel resultViewModel;

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController(final InputViewModel inputViewModel, final ResultViewModel resultViewModel) {
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
        this.inputView = new InputView(inputViewModel);
        this.resultView = new ResultView(resultViewModel);
    }

    public void gameStart() {
        inputPhase();
        Users users = Users.fromString(inputViewModel.getUsernamesString());

        LadderGame ladderGame = new LadderGame(
                LadderFactoryBean.createLadderFactory().create(users.size(), inputViewModel.getHeight()),
                new UserRewardSet(users, Rewards.fromString(inputViewModel.getRewardsString())));
        drawLadderResult(users, ladderGame);
        drawResultCheckView(ladderGame.ladderResult());
    }

    private void drawLadderResult(Users users, LadderGame ladderGame) {
        resultViewModel.saveUsernamesString(users.toString());
        resultViewModel.saveLadderString(ladderGame.ladderBoard());
        resultViewModel.saveRewardsString(Rewards.fromString(inputViewModel.getRewardsString()).toString());
        resultView.drawLadderResultView();
    }

    private void inputPhase() {
        inputView.drawInputUserNames();
        inputView.drawInputRewards();
        inputView.drawInputLadderHeight();
    }

    private void drawResultCheckView(LadderGameResult ladderGameResult) {
        boolean canGo = true;
        while (canGo) {
            inputView.drawInputResult();
            User inputUser = User.from(inputViewModel.getUsernameString());
            canGo = !inputUser.isAll();
            resultViewModel.saveResultString(ladderGameResult.resultSting(inputUser));
            resultView.drawResultView();
        }
    }
}
