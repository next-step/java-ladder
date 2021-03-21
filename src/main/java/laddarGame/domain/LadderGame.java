package laddarGame.domain;

import laddarGame.dto.LadderDto;
import laddarGame.dto.PlayersDto;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(String playerNames, int ladderHeight) {
        this.players = new Players(playerNames);
        this.ladder = new Ladder(players.maxNameLength(), players.playerCount(), ladderHeight);
    }

    public PlayersDto playersDto() {
        return new PlayersDto(players.plyersDto());
    }

    public LadderDto ladderDto() {
        return new LadderDto(ladder.linesDto());
    }
}

