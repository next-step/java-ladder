package ladder.domain;

public class GameInfo {

    private final Participants participants;
    private final Goals goals;

    private GameInfo(Participants participants, Goals goals) {
        this.participants = participants;
        this.goals = goals;
    }

    public static GameInfo of(Participants participants, Goals goals) {
        if (participants.size() != goals.size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다. 참가자 수=" + participants.size() + ", 결과 수=" + goals.size());
        }

        return new GameInfo(participants, goals);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Goals getGoals() {
        return goals;
    }
}
