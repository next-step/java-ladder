package ladder.domain.result;

import ladder.domain.participants.Gamer;
import ladder.domain.participants.Name;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RewardResult)) return false;
        RewardResult that = (RewardResult) o;
        return Objects.equals(reward, that.reward) && Objects.equals(gamer, that.gamer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward, gamer);
    }
}
