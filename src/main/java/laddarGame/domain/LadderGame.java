package laddarGame.domain;

import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayersDto;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(String playerNames, int ladderHeight) {
        this.players = new Players(playerNames);
        this.ladder = new Ladder(players.playerCount(), ladderHeight);
    }

    public PlayersDto playersDto() {
        return new PlayersDto(players.playersDto());
    }

    public LinesDto ladderDto() {
        return new LinesDto(ladder.linesDto());
    }

    public List<String> play() {
        return ladder.play(players);
    }

    public static LadderCreateStrategy createStrategy() {
        return LadderCreateStrategy.getInstance();
    }
}

