package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.RandomDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Participants participants = InputView.inputParticipants();
        Heights heights = InputView.inputHeights();
        Round round = Round.valueOf(heights);

        OutputView.resultOutput(participants);
        while (round.hasMoreRound()) {
            Lines lines = round.drawLadder(participants, new RandomDrawStrategy());
            OutputView.printLadders(lines);
        }
    }
}
