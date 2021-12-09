package step4.domain;

public class GameInfo {
    private final Participants participants;
    private final Rewards rewards;

    private GameInfo(Participants participants, Rewards rewards) {
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
}
