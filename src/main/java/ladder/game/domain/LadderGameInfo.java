package ladder.game.domain;

import ladder.player.domain.Player;
import ladder.player.domain.Players;
import ladder.prize.domain.Prize;
import ladder.prize.domain.Prizes;

public class LadderGameInfo {
    private final Players players;
    private final Prizes prizes;

    private LadderGameInfo(Players players, Prizes prizes) {
        validate(players, prizes);
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderGameInfo of(Players players, Prizes prizes) {
        return new LadderGameInfo(players, prizes);
    }

    private void validate(Players players, Prizes prizes) {
        if (players.size() != prizes.size()) {
            throw new DoseNotMatchCountException();
        }
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public Prize getResult(int resultIndex) {
        return prizes.getPrize(resultIndex);
    }

    public Player getPlayer(int index) {
        return players.getPlayer(index);
    }

    public int size() {
        return players.size();
    }
}
