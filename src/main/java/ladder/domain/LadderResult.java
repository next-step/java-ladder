package ladder.domain;

public class LadderResult {
    private final Player player;
    private final String reward;

    public LadderResult(Player player, String reward) {
        this.player = player;
        this.reward = reward;
    }

    public String playerName() {
        return this.player.name();
    }

    public String reward() {
        return this.reward;
    }
}
