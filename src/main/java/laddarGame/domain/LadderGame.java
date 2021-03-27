package laddarGame.domain;

import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayersDto;

import java.util.List;

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

    public List<String> play() {
        return lines.play(players);
    }

    public static LadderCreateStrategy createStrategy() {
        return LadderCreateStrategy.getInstance();
    }
}

