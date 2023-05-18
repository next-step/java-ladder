package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.util.RandomStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        LadderInputs participants = InputView.inputNames();
        LadderInputs reward = InputView.inputResults(participants);
        Heights heights = InputView.inputHeights();

        Ladder ladder = Ladder.from(heights, participants, new RandomStrategy());
        OutputView.printLadder(participants, ladder, reward);

        Results results = ladder.move();

        boolean flag = true;
        while (flag) {
            flag = printResult(results, participants, reward);
        }
    }

    private static boolean printResult(Results results, LadderInputs participants, LadderInputs reward) {
        LadderInput name = InputView.inputReward();

        if (name.equals(new LadderInput("all"))) {
            OutputView.printResultAll(results, participants, reward);
            return false;
        }

        if (!participants.hasName(name)) {
            OutputView.printNotExistsName(name);
        }

        if (participants.hasName(name)) {
            int index = participants.nameIndex(name);
            String matchedResult = results.matchedResult(index, reward);
            OutputView.printResult(matchedResult);
        }

        return true;
    }

}
