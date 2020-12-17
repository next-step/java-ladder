package ladder.domain.dto;

import ladder.domain.participant.Position;
import ladder.exception.NotFoundRewardException;

import java.util.Collections;
import java.util.List;

public class Rewards {

    private final List<String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public String findRewardByPosition(Position position) {
        if(position.getRow() > rewards.size()) {
            throw new NotFoundRewardException();
        }
        return rewards.get(position.getRow());
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}