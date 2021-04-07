package nextstep.ladder.dto;

public class RewardDto {

    private final String reward;

    public RewardDto(String reward) {
        this.reward = reward;
    }

    public String getRewardString() {
        return reward;
    }
}
