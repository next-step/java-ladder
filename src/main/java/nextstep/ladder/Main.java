package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderInputs participants = InputView.inputNames();
        LadderInputs reward = InputView.inputResults(participants);
        Heights heights = InputView.inputHeights();

        Ladder ladder = Ladder.from(heights, participants, new RandomDrawStrategy());
        OutputView.printLadder(participants, ladder, reward);

        Results ladderResults = ladder.getResults(Results.init(participants));

        boolean flag = true;
        while (flag) {
            flag = printResult(ladderResults, participants, reward);
        }
    }

    private static boolean printResult(Results ladderResults, LadderInputs participants, LadderInputs reward) {
        Input name = InputView.inputReward();

        if (name.equals(new Input("all"))) {
            OutputView.printResultAll(ladderResults, participants, reward);
            return false;
        }

        if (!participants.hasName(name)) {
            OutputView.printNoName(name);
        }

        if (participants.hasName(name)) {
            OutputView.printResult(ladderResults.matchResult(participants.nameIndex(name), reward));
        }

        return true;
    }
}
