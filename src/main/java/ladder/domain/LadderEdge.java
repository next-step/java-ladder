package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderEdge {
    private final Players players;
    private final Rewards rewards;

    public LadderEdge(Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
    }

    public int playerSize() {
        return this.players.size();
    }

    public Player player(int index) {
        return this.players.getPlayer(index);
    }

    public Reward reward(int index) {
        return this.rewards.getReward(index);
    }

    public List<String> players() {
        return this.players.players()
                .stream()
                .map(player -> player.toString())
                .collect(Collectors.toList());
    }

    public List<String> rewards() {
        return this.rewards.rewards()
                .stream()
                .map(reward -> reward.toString())
                .collect(Collectors.toList());
    }
}
