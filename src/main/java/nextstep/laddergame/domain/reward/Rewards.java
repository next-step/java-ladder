package nextstep.laddergame.domain.reward;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(int participantsCount, String rewards) {
        final List<String> splitRewards = this.splitRewards(rewards);

        this.checkRewardSize(participantsCount, splitRewards);

        this.rewards = this.makeRewards(splitRewards);
    }

    private List<String> splitRewards(String rewards) {
        return List.of(Optional.ofNullable(rewards)
                .map(it -> it.split(","))
                .orElseThrow(() -> new IllegalArgumentException("보상은 빈값일 수 없습니다.")));
    }

    private void checkRewardSize(int participantsCount, List<String> rewards) {
        if (rewards.size() != participantsCount) {
            throw new IllegalArgumentException("보상은 인원수와 같아야합니다.");
        }
    }

    private List<Reward> makeRewards(List<String> splitRewards) {
        return splitRewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getRewardBy(int index) {
        return this.rewards.get(index);
    }
}
