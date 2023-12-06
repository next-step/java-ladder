package com.fineroot.viewmodel;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.viewmodel.InputViewModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewModelTest {
    @Test
    @DisplayName("ladderHeight 저장")
    void saveLadderHeight() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveLadderHeight(5);
        assertThat(inputViewModel.getHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("usernamesString 저장")
    void saveUsernamesString() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveUsernamesString("a,b,c,d");
        assertThat(inputViewModel.getUsernamesString()).isEqualTo("a,b,c,d");
    }

    @Test
    @DisplayName("rewardsString 저장")
    void saveRewardsString() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveRewardsString("a,b,c,d");
        assertThat(inputViewModel.getRewardsString()).isEqualTo("a,b,c,d");
    }

    @Test
    @DisplayName("username 저장")
    void saveUsernameString() {
        InputViewModel inputViewModel = new InputViewModel();
        inputViewModel.saveUsernameString("pobi");
        assertThat(inputViewModel.getUsernameString()).isEqualTo("pobi");
    }
}
