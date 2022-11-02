package ladder.domain.reward;

import ladder.domain.person.Position;
import ladder.exception.result.ResultNotExistException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rewards {

    public final List<Reward> rewards;

    public Rewards(String... strings) {
        this.rewards = Stream.of(strings)
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public List<Reward> rewards() {
        return Collections.unmodifiableList(rewards);
    }

    public Reward reward(Position position) {
        validRewardBound(position);
        return rewards.get(position.x());
    }

    private void validRewardBound(Position position) {
        if (rewards.size() < position.x()) {
            throw new ResultNotExistException();
        }
    }
}
