package com.fineroot.viewmodel;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.domain.LadderGameResult;
import com.fineroot.ladder.engine.Positions;
import com.fineroot.ladder.domain.Rewards;
import com.fineroot.ladder.domain.User;
import com.fineroot.ladder.domain.UserRewardSet;
import com.fineroot.ladder.domain.Users;
import com.fineroot.ladder.viewmodel.ResultViewModel;
import org.junit.jupiter.api.Test;

class ResultViewModelTest {
    @Test
    void saveUsernameString() {
        ResultViewModel resultViewModel = new ResultViewModel();
        resultViewModel.saveUsernamesString("pobi  honux crong    jk");
        assertThat(resultViewModel.getUsernamesString()).isEqualTo("pobi  honux crong    jk");
    }

    @Test
    void saveLadderString() {
        ResultViewModel resultViewModel = new ResultViewModel();
        resultViewModel.saveLadderString("|-----|     |-----|");
        assertThat(resultViewModel.getLadderString()).isEqualTo("|-----|     |-----|");
    }

    @Test
    void saveLadderResult() {
        ResultViewModel resultViewModel = new ResultViewModel();
        LadderGameResult ladderGameResult = new LadderGameResult(
                new UserRewardSet(Users.fromString("pobi,honux,crong,jk"),
                        Rewards.fromString("꽝,3000,꽝,2000")),
                Positions.fromIntArray(0,1,2,3));
        resultViewModel.saveResultString(ladderGameResult.resultSting(User.from("all")));
        assertThat(resultViewModel.getResultString()).isEqualTo(
                "pobi : 꽝\n honux : 3000\n crong : 꽝\n jk : 2000");
    }
}
