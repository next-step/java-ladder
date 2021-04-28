package nextstep.ladder2.domain;

public class NxPrizeMapper {
    private final NxPlayers players;
    private final NxPrizes prizes;

    public NxPrizeMapper(NxPlayers players, NxPrizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public NxResult getPrize(int start, int end) {
        return new NxResult(players.get(start), prizes.getPrizeByIndex(end));
    }
}
