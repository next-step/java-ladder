package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(List<String> participantNames, int height) {
        this.participants = new Participants(participantNames);
        this.ladder = new Ladder(height, participantNames.size());
    }

    public void play() {
        OutputView.printResultTitle();
        OutputView.printParticipants(participants.getValues().stream().map(Participant::getName).collect(Collectors.toList()));
        OutputView.printLadder(ladder.getLines());
    }
}
