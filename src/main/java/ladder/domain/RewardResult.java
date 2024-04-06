package ladder.domain;

import ladder.domain.participants.Gamer;
import ladder.domain.participants.Name;
import ladder.domain.result.Reward;

public class RewardResult {

    private final Reward reward;
    private final Gamer gamer;

    public RewardResult(Reward reward, Gamer gamer) {
        this.reward = reward;
        this.gamer = gamer;
    }

    public Reward getReword() {
        return reward;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public boolean isSameName(Name nameToFind) {
        return gamer.hasSameName(nameToFind);
    }
}
