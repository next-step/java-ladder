package step4.domain;

public class GameInfo {
    private final Participants participants;
    private final Rewards rewards;

    private GameInfo(Participants participants, Rewards rewards) {
        validateSizeEquals(participants.size(), rewards.size());
        this.participants = participants;
        this.rewards = rewards;
    }

    public static GameInfo of(Participants participants, Rewards rewards) {
        return new GameInfo(participants, rewards);
    }

    public Participants participants() {
        return participants;
    }

    public Rewards rewards() {
        return rewards;
    }

    private void validateSizeEquals(int participantSize, int rewardSize) {
        if (participantSize != rewardSize) {
            throw new IllegalArgumentException("참가자와 보상의 수가 일치하지 않습니다.");
        }
    }
}
