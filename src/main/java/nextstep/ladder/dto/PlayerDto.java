package nextstep.ladder.dto;

import nextstep.ladder.Player;

public class PlayerDto {

    private final PlayerNameDto playerName;

    public PlayerDto(Player player) {
        playerName = new PlayerNameDto(player.getPlayerName());
    }

    public String getPlayerName() {
        return playerName.getPlayerName();
    }
}
