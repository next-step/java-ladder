package nextstep.controller;

import nextstep.domain.*;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class LadderGameController {

    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        InputResults inputResults
                = new InputResults(InputView.inputLadderResult(), usernames.size());
        int ladderHeight = InputView.inputLadderHeightMax();

        Lines lines = new Lines(usernames.size(), ladderHeight);
        OutputView.outputUserNames(usernames.getUsernames());
        OutputView.outputLadder(lines);
        OutputView.outputLadderResult(inputResults.getResults());

        Ladder ladder = new Ladder(lines, usernames.size());
        LadderResult ladderResult = new LadderResult(ladder, usernames, inputResults);

        while (true) {
            Username name = new Username(InputView.inputUsernameForResult());
            OutputView.outputExecutionResult(ladderResult.getLadderResult(name));

            if (name.equals(new Username("all"))) {
                break;
            }
        }
    }
}
