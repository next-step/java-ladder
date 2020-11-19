package ladder.dto.response;

import ladder.domain.Players;

public class LadderDto {
    private final Players players;

    public LadderDto(Players players) {
        this.players = players;
    }

    public Players getPlayers() {
        return players;
    }
}
