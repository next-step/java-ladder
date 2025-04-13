import domain.Ladder;
import domain.Participants;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame() {
        List<String> participantNames = InputView.inputParticipantNames();
        int maxLadderHeight = InputView.inputMaxLadderHeight();
        this.participants = new Participants(participantNames);
        this.ladder = new Ladder(maxLadderHeight, participantNames.size());
    }

    public void play() {
        OutputView.printResultTitle();
        OutputView.printParticipants(participants);
        OutputView.printLadder(ladder.getLines());
    }
}
