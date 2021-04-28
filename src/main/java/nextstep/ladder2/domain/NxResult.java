package nextstep.ladder2.domain;

public class NxResult {
    private final NxPlayer player;
    private final NxPrize prize;

    public NxResult(NxPlayer player, NxPrize prize) {
        this.player = player;
        this.prize = prize;
    }

    public boolean findPlayer(NxPlayer player) {
        return this.player.equals(player);
    }

    public NxPrize getPrize() {
        return prize;
    }
}
