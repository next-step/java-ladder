package step4.dto;

import java.util.List;

import step4.domain.Player;

public class PlayersDto {
    private final List<Player> players;

    public PlayersDto(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
