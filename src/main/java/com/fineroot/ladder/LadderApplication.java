package com.fineroot.ladder;

import com.fineroot.ladder.viewmodel.InputViewModel;
import com.fineroot.ladder.viewmodel.ResultViewModel;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputViewModel(),
                new ResultViewModel());
        ladderGameController.gameStart();
    }
}
