package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomLineStrategy;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = Input.initLadderGame(new RandomLineStrategy());
        Output.printLadderResult(ladderGame);
        String nameToShowResult = Input.getNameToShowResult();
        Output.printResult(ladderGame, nameToShowResult);
    }
}
