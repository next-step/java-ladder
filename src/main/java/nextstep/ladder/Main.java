package nextstep.ladder;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.LadderInput;
import nextstep.ladder.domain.LadderInputs;
import nextstep.ladder.view.InputView;

public class Main {

    public static void main(String[] args) {
        LadderInputs participants = InputView.inputNames();
        LadderInputs ladderResults = InputView.inputResults(participants);
        Heights heights = InputView.inputHeights();

        LadderInput name = InputView.inputReward();
    }

}
