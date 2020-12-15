package nextstep.ladder;

import nextstep.ladder.service.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class ladderGameMain {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView(), new ResultView());
        ladderGame.operator();
    }
}