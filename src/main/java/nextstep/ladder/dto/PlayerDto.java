package nextstep.ladder.dto;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.reward.Reward;

public class PlayerDto {

    private final String name;
    private final String reward;

    public PlayerDto(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }

    public static PlayerDto of(Player player, Reward reward) {
        return new PlayerDto(player.exportName(), reward.export());
    }

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }
}
