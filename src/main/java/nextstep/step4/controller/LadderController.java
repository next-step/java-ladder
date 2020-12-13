package nextstep.step4.controller;

import nextstep.step4.domain.GameCriteria;
import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.OutputView;
import nextstep.step4.view.InputView;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameCriteria gameCriteria = inputView.getGameCriteria();
        int height = inputView.getHeight();

        outputView.mentionResult();
        Ladder ladder = Ladder.init(gameCriteria.getUserNumbers(), height);


    }
}
