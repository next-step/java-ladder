package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.strategy.RandomRuleStrategy;
import nextstep.ladder.strategy.RuleStrategy;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.resultView.printLadder;

public class ladderMain {

    private static RuleStrategy ruleStrategy = new RandomRuleStrategy();

    public static void main(String[] args) {
        Names names = new Names(inputNames());
        int height = inputHeight();
        Ladder ladder = new Ladder(height, names.size(), ruleStrategy);
        printLadder(names, ladder);
    }
}
