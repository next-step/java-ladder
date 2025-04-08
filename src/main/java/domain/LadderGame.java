package domain;

import view.OutputView;

import java.util.List;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(List<String> participantNames, int height) {
        this.participants = new Participants(participantNames);
        this.ladder = new Ladder(height, participantNames.size());
    }

    public void play() {
        OutputView.printResultTitle();
        OutputView.printParticipants(participants.getParticipantsName());
        OutputView.printLadder(ladder.getLines());
    }
}
