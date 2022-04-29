package nextstep.ladder.dto;

import nextstep.ladder.PlayerName;

public class PlayerNameDto {

    private final String playerName;

    public PlayerNameDto(PlayerName playerName) {
        this.playerName = playerName.getPlayerName();
    }

    public String getPlayerName() {
        return playerName;
    }
}
