package laddergame.domain.game.dto;

import laddergame.domain.game.Prizes;
import laddergame.domain.player.Players;
import laddergame.domain.vo.Height;

public class GameInfoDto {
    private final Players players;
    private final Prizes prizes;
    private final Height ladderHeight;

    public GameInfoDto(final String[] players, final String[] prizes, final int ladderHeight) {
        this.players = new Players(players);
        this.prizes = new Prizes(prizes);
        this.ladderHeight = new Height(ladderHeight);
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public Height getLadderHeight() {
        return ladderHeight;
    }
}
