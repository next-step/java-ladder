package ladder.controller;

import ladder.domain.Player;

public class LadderResult {
    private final Player player;
    private final Reward reward;

    public LadderResult(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public String playerName() {
        return this.player.name();
    }

    public String reward() {
        return this.reward.value();
    }
}
