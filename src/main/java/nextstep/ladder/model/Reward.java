package nextstep.ladder.model;

public class Reward {
    public static final int MAX_REWARD_LENGTH = 5;
    private static final String EMPTY = "";

    private String reward;

    public Reward(String reward) {
        String trimming = reward.trim();

        if (EMPTY.equals(trimming) || trimming.length() > MAX_REWARD_LENGTH) {
            throw new IllegalArgumentException("Reward value is not invalid , reward : " + reward);
        }

        this.reward = trimming;
    }

    @Override
    public String toString() {
        return reward;
    }
}
