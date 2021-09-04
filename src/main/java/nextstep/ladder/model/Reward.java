package nextstep.ladder.model;

public class Reward {
    public static final int MAX_REWARD_LENGTH = 5;
    private static final String EMPTY = "";

    private String reward;

    public Reward(String reward) {
        String trimming = reward.trim();

        if (trimming.length() > MAX_REWARD_LENGTH) {
            throw new IllegalArgumentException("보상 값이 너무 깁니다. 보상값 : " + reward);
        }

        if (EMPTY.equals(trimming)) {
            throw new IllegalArgumentException("보상 값이 비어 있습니다. ");
        }

        this.reward = trimming;
    }

    @Override
    public String toString() {
        return reward;
    }
}
