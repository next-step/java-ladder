package laddarGame.domain;

import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayersDto;

public class LadderGame {

    private final Lines lines;
    private final Players players;

    public LadderGame(String playerNames, int ladderHeight) {
        this.players = new Players(playerNames);
        this.lines = new Lines(players.playerCount(), ladderHeight);
    }

    public PlayersDto playersDto() {
        return new PlayersDto(players.playersDto());
    }

    public LinesDto ladderDto() {
        return new LinesDto(lines.linesDto());
    }
}

