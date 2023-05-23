package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = new Input().initLadder();
        new Output().printResult(ladderGame);
    }
}
