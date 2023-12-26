package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.Rewards;

public class RewardsResponse {
    private final String rewards;

    public static RewardsResponse from(Rewards rewards) {
        StringBuilder stringBuilder = rewards.getRewards().stream()
                .collect(
                        StringBuilder::new,
                        (sb, s) -> sb.append(String.format("%1$6s", s)),
                        StringBuilder::append
                );
        stringBuilder.deleteCharAt(0);
        return new RewardsResponse(stringBuilder.toString());
    }

    private RewardsResponse(String rewards) {
        this.rewards = rewards;
    }

    public String getResponse() {
        return rewards;
    }
}
