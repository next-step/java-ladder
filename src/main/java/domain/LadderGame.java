package domain;

import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
