package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.laddergame.engine.LadderGameResult;
import nextstep.refactoring.laddergame.engine.player.Player;
import nextstep.refactoring.laddergame.engine.reward.Reward;

import java.util.Objects;

public class LadderGameResultImpl implements LadderGameResult {

    private final Player player;
    private final Reward reward;

    public LadderGameResultImpl(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Reward getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameResultImpl)) return false;
        LadderGameResultImpl that = (LadderGameResultImpl) o;
        return Objects.equals(player, that.player) && Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, reward);
    }
}
