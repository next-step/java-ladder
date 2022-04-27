package nextstep.ladder;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Participants participants = createParticipants();
        int height = InputView.promptHeight();

        Lines lines = Lines.createLines(participants.size(), height);

        OutputView.printParticipants(participants);
        OutputView.printLines(lines);
    }

    private static Participants createParticipants() {
        List<String> names = InputView.promptNames();
        List<Participant> participants = Participant.createParticipants(names);
        return new Participants(participants);
    }
}
