package ladder.domain.reward;

import ladder.domain.point.Position;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validate(rewards);
        this.rewards = new ArrayList<>(rewards);
    }

    private void validate(List<Reward> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("rewards는 빈 값 일 수 없습니다.");
        }
    }

    public boolean isSameNumbers(int playerSize) {
        return rewards.size() == playerSize;
    }

    public static Rewards from(List<String> rewardNames) {
        List<Reward> rewards = new ArrayList<>();

        for (int i = 0; i < rewardNames.size(); i++) {
            rewards.add(new Reward(rewardNames.get(i), i));
        }

        return new Rewards(rewards);
    }

    public Reward findByPosition(Position position) {
        return rewards.stream()
                .filter(reward -> reward.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("position(%s)이 올바르지 않습니다.", position)));
    }

    @Override
    public String toString() {
        return rewards.stream()
                .map(reward -> OutputView.nameToDisplayingName(reward.toString()))
                .collect(Collectors.joining());
    }
}
