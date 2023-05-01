package nextstep.ladder;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Round;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Participants participants = InputView.inputParticipants();
        Heights heights = InputView.inputHeights();
        Round round = Round.valueOf(heights);

        OutputView.resultOutput(participants);
        while (round.hasMoreRound()) {
            round.startRadder(participants);
        }

    }
}
