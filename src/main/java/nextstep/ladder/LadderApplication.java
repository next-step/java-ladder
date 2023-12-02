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
        Amounts amounts = new Amounts(inputAmounts);
        Ladder ladder = new Ladder(players, height, new RandomLineStrategy());
        LadderGame ladderGame = new LadderGame(players, ladder, amounts);
        OutputView.printLadder(players, ladder, amounts);

        LadderGameResult ladderGameResult = ladderGame.play();
        OutputView.printResult(ladderGameResult);
    }
}
