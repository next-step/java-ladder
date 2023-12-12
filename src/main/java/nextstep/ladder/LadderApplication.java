package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.concrete.Ladder;
import nextstep.ladder.domain.concrete.NormalLadderCreateStrategy;
import nextstep.ladder.domain.concrete.RandomLineCreateStrategy;
import nextstep.ladder.domain.strategy.LadderCreateStrategy;
import nextstep.ladder.domain.strategy.LineCreateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = new Players(InputView.inputNames());
        Amounts amounts = new Amounts(InputView.inputAmounts());
        Height height = new Height(InputView.inputHeight());

        LineCreateStrategy lineCreateStrategy = new RandomLineCreateStrategy();
        LadderCreateStrategy ladderCreateStrategy = new NormalLadderCreateStrategy(lineCreateStrategy);
        Ladder ladder = ladderCreateStrategy.create(players, height);
        LadderGame ladderGame = new LadderGame(players, ladder, amounts);
        OutputView.printLadder(players, ladder, amounts);

        LadderGameResult ladderGameResult = ladderGame.play();
        OutputView.printResultLoop(ladderGameResult);
    }
}
