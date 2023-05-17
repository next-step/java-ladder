package nextstep.controller;

import nextstep.domain.*;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> ladderResults = getLadderResult(ladder, usernames);
        OutputView.outputExecutionResult(ladderResults, inputResults, usernames);
        ladderResults = getLadderResult(ladder, usernames);
        OutputView.outputExecutionResult(ladderResults, inputResults, usernames);
    }

    private static List<Integer> getLadderResult(Ladder ladder, Usernames usernames) {
        String input = InputView.inputUsernameForResult();

        if (input.equals("all")) {
            return ladder.getResults();
        }
        return List.of(ladder.getResult(new Username(input), usernames));
    }
}
