package ladder.domain.dto;

import ladder.domain.participant.Position;
import ladder.exception.NotFoundRewardException;

import java.util.List;

public class Rewards {

    private final List<String> reward;

    public Rewards(List<String> reward) {
        this.reward = reward;
    }

    public String findRewardByPosition(Position position) {
        if(position.getRow() > reward.size()) {
            throw new NotFoundRewardException();
        }
        return reward.get(position.getRow());

    }

    public List<String> getReward() {
        return reward;
    }
}