package ladder.game.dto;

import ladder.game.domain.LadderGameInfo;
import ladder.ladder.domain.Ladder;
import ladder.player.domain.Players;
import ladder.prize.domain.Prizes;

public class LadderGameDto {

    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    private LadderGameDto(Players players, Prizes prizes, Ladder ladder) {
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public static LadderGameDto of(LadderGameInfo ladderGameInfo, Ladder ladder) {
        return new LadderGameDto(ladderGameInfo.getPlayers(), ladderGameInfo.getPrizes(), ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
