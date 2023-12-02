package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.RandomLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        Players players = new Players(inputNames);
        int inputHeight = InputView.inputHeight();
        Height height = new Height(inputHeight);
        String inputAmounts = InputView.inputAmounts();
        ResultAmounts resultAmounts = new ResultAmounts(inputAmounts);
        Ladder ladder = new Ladder(players, height, new RandomLineStrategy());
        LadderGame ladderGame = new LadderGame(players, ladder, resultAmounts);
        OutputView.printLadder(players, ladder, resultAmounts);

        LadderResult ladderResult = ladderGame.play();
        OutputView.printResult(ladderResult);
    }
}
