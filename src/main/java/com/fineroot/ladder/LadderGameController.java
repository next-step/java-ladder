package com.fineroot.ladder;

import com.fineroot.ladder.domain.Ladder;
import com.fineroot.ladder.domain.LadderGame;
import com.fineroot.ladder.domain.Users;
import com.fineroot.ladder.view.InputView;
import com.fineroot.ladder.view.ResultView;
import com.fineroot.ladder.viewmodel.InputViewModel;
import com.fineroot.ladder.viewmodel.ResultViewModel;

public class LadderGameController {

    private final InputViewModel inputViewModel;
    private final ResultViewModel resultViewModel;

    public LadderGameController(final InputViewModel inputViewModel, final ResultViewModel resultViewModel) {
        this.inputViewModel = inputViewModel;
        this.resultViewModel = resultViewModel;
    }

    public void gameStart() {
        InputView inputView = new InputView(inputViewModel);
        ResultView resultView = new ResultView(resultViewModel);
        inputView.drawInputUserNames();
        inputView.drawInputLadderHeight();
        Users users = Users.fromString(inputViewModel.getUsernameString());
        resultViewModel.saveLadderString(
                new LadderGame(Ladder.of(users, inputViewModel.getHeight()), users).ladderBoard());
        resultViewModel.saveUsernameString(users.toString());
        resultView.drawResultView();
    }
}
