package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.controller.LadderController;
import me.namuhuchutong.ladder.domain.implement.factory.ScaffoldRandomFactory;
import me.namuhuchutong.ladder.ui.InputView;
import me.namuhuchutong.ladder.ui.OutputView;

public class LadderGameApplication {

    public static void main(String[] args){
        new LadderController(new InputView(),
                             new ScaffoldRandomFactory(),
                             new OutputView()).start();
    }
}
