package laddarGame.dto;

import java.util.List;

public class PlayersDto {

    private final List<PlayerDto> playerList;

    public PlayersDto(List<PlayerDto> playerList) {
        this.playerList = playerList;
    }

    public List<PlayerDto> getPlayerList() {
        return playerList;
    }


}
