package nextstep.ladder2.domain;

import nextstep.ladder2.domain.result.NxResult;
import nextstep.ladder2.domain.player.NxPlayers;
import nextstep.ladder2.domain.prize.NxPrizes;

public class NxPrizeMapper {
    private final NxPlayers players;
    private final NxPrizes prizes;

    public NxPrizeMapper(NxPlayers players, NxPrizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public NxResult createResult(int start, int end) {
        return new NxResult(players.get(start), prizes.getPrizeByIndex(end));
    }

    public int getPlayerCount() {
        return players.getPlayerCount();
    }
}
