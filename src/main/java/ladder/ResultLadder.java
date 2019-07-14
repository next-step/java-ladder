package ladder;

public class ResultLadder {
    private Player player;
    private Prize prize;

    private ResultLadder(Player player, Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public static ResultLadder of(Player player, Prize prize) {
        return new ResultLadder(player, prize);
    }

    public Player getPlayer() {
        return player;
    }

    public Prize getPrize() {
        return prize;
    }
}
