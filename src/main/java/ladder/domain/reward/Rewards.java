package ladder.domain.reward;

import ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    private Rewards(String input) {
        this.rewards = StringUtil.convertList(input)
                .stream()
                .map(Reward::of)
                .collect(Collectors.toList());
    }

    public static Rewards of(String input) {
        return new Rewards(input);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public String getNameByPosition(int position) {
        if (0 > position || rewards.size() - 1 < position) {
            throw new IllegalArgumentException("당첨결과가 없습니다. 입력값을 확인해 주세요.");
        }
        return rewards.get(position).getName();
    }

    public int getCountOfRewards() {
        return this.rewards.size();
    }

}
