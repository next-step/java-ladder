package ladder.domain;

public class LadderGameResult {
    private final Player player;
    private final Prize prize;

    public LadderGameResult(Player player, Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public boolean hasPlayerName(String playerName) {
        return player.isSameName(playerName);
    }

    public Prize getPrize() {
        return prize;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPrizeValue() {
        return prize.getValue();
    }
}
