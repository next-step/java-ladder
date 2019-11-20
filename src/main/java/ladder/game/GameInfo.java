package ladder.game;

public class GameInfo {
    private final Participants participants;
    private final Prizes prizes;

    public GameInfo(String inputParticipant, String inputResults) {
        this.participants = new Participants(inputParticipant);
        this.prizes = Prizes.of(inputResults, this.participants.size());
    }

    public int getParticipantsSize() {
        return this.participants.size();
    }

    public Participants getParticipants() {
        return participants;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
