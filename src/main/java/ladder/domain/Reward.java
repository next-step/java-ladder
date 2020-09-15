package ladder.domain;

public class Reward {
    private String reward;
    private int position;

    public Reward(int position, String reward) {
        this.position = position;
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    public boolean equalPosition(int userPosition) {
        return position == userPosition;
    }
}
