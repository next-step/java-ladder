package ladder.dto;

import ladder.domain.PlayResults;
import ladder.domain.Players;

public class GameInfo {
    private Players players;
    private PlayResults playResults;

    public GameInfo(Players players, PlayResults playResults) {
        validate(players, playResults);
        this.players = players;
        this.playResults = playResults;
    }

    public Players getPlayers() {
        return players;
    }

    public PlayResults getPlayResults() {
        return playResults;
    }

    private void validate(Players players, PlayResults playResults) {
        if (players.getCount() != playResults.getCount()) {
            throw new IllegalArgumentException("플레이어수와 결과개수는 일치해야 합니다.");
        }
    }
}
