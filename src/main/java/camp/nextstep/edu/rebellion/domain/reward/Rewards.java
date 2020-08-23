package camp.nextstep.edu.rebellion.domain.reward;

import camp.nextstep.edu.rebellion.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(String input) {
        this.rewards = StringUtil.convertList(input)
                .stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public String findNameByPosition(int position) {
        if (0 > position || rewards.size() - 1 < position) {
            throw new IllegalArgumentException("당첨결과가 없습니다 입력값을 확인해 주세요 : "
                    + position);
        }

        return rewards.get(position).getName();
    }

    public int getCountOfRewards() {
        return this.rewards.size();
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
