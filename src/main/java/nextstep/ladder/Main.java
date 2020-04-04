package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGame.play(new InputView(), new OutputView());
    }
}
