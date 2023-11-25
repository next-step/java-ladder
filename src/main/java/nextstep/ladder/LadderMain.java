package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.strategy.RandomRuleStrategy;
import nextstep.ladder.strategy.RuleStrategy;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.ResultView.*;

public class LadderMain {

    private static RuleStrategy ruleStrategy = new RandomRuleStrategy();

    public static void main(String[] args) {
        Names names = new Names(inputNames());
        Results results = new Results(inputResult());
        results.validateSize(names.size());
        Ladder ladder = new Ladder(inputHeight(), names.size(), ruleStrategy);
        LadderResult ladderResult = new LadderResult(results.of(names, ladder));

        printLadder(names, ladder, results);
        printUserResult(ladderResult, new Name(inputResultName()));
    }
}
