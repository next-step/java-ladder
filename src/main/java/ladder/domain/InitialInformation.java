package ladder.domain;

import java.util.List;

public class InitialInformation {
    private final Points participants;
    private final Points winningItems;
    private final int ladderHeight;

    public InitialInformation(List<String> participantNames, List<String> winningItemNames, int ladderHeight) {
        this.participants = Points.createPointsByNames(participantNames);
        this.winningItems = Points.createPointsByNames(winningItemNames);
        this.ladderHeight = ladderHeight;
    }

    public int maxNameSize() {
        return Math.max(participants.pointNameMaxSize(), winningItems.pointNameMaxSize());
    }

    public int calculatedLadderLength() {
        return participants.size() - 1;
    }

    public Points getParticipants() {
        return participants;
    }

    public Points getWinningItems() {
        return winningItems;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
