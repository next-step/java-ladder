package ladder.dto.request;

import java.util.List;

public class PlayersDto {
    private final List<String> players;

    public PlayersDto(List<String> players) {
        this.players = players;
    }

    public List<String> getPlayers() {
        return players;
    }
}
