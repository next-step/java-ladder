package step3_renewal.domain;

public class GameResult {
    private String participantName;
    private Reward reward;

    private GameResult(String participantName, Reward reward) {
        this.participantName = participantName;
        this.reward = reward;
    }

    public static GameResult of(String participantName, String reward) {
        return new GameResult(participantName, Reward.of(reward));
    }

    public String getParticipantName() {
        return participantName;
    }

    public Reward getReward() {
        return reward;
    }

}
