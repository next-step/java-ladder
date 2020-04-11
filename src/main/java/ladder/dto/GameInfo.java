package ladder.dto;

import ladder.domain.Prizes;
import ladder.domain.Players;

public class GameInfo {
    private Players players;
    private Prizes prizes;

    public GameInfo(Players players, Prizes prizes) {
        validate(players, prizes);
        this.players = players;
        this.prizes = prizes;
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    private void validate(Players players, Prizes prizes) {
        if (players.count() != prizes.count()) {
            throw new IllegalArgumentException("플레이어수와 결과개수는 일치해야 합니다.");
        }
    }
}
