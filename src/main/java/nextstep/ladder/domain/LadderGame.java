package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;

    private final Lines lines;

    private final LadderResults ladderResults;

    public LadderGame(String[] participants, String[] ladderResults, int height) {
        this.participants = new Participants(participants);
        this.ladderResults = new LadderResults(ladderResults, this.participants.numberOfParticipants());
        this.lines = new Lines(height, this.participants.numberOfParticipants());

        matchResults();
    }

    void matchResults() {
        for (int i = 0; i < this.participants.numberOfParticipants(); i++) {
            goToResult(i, this.lines.value().size(), this.participants.numberOfParticipants());
        }
    }

    private void goToResult(int startIndex, int height, int numberOfParticipants) {
        int endIndex = startIndex;
        for (int h = 0; h < height; h++) {
            endIndex = move(endIndex, h, numberOfParticipants);
        }
        this.participants.value().get(startIndex).matchResult(this.ladderResults.value().get(endIndex));
    }

    private int move(int currentIndex, int currentHeight, int numberOfParticipants) {
        if (currentIndex > 0 && this.lines.value().get(currentHeight).edges().get(currentIndex - 1).linked()) {
            return currentIndex - 1;
        }
        if (currentIndex < numberOfParticipants - 1 && this.lines.value().get(currentHeight).edges().get(currentIndex).linked()) {
            return currentIndex + 1;
        }
        return currentIndex;
    }

    String resultOfParticipant(String name) {
        return this.participants.findByName(name);
    }

    public String view() {
        return this.lines.toLadderLines();
    }

    public Participants participants() {
        return participants;
    }

    public LadderResults ladderResults() {
        return ladderResults;
    }
}
