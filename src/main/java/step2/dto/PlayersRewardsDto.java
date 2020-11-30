package step2.dto;

import step2.domain.Players;
import step2.domain.Rewards;

public class PlayersRewardsDto {

    private final Players players;
    private final Rewards rewards;

    public PlayersRewardsDto(Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
    }

    public Players getPlayers() {
        return players;
    }

    public Rewards getRewards() {
        return rewards;
    }
}
