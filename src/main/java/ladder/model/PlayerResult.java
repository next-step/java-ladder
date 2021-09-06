package ladder.model;

public class PlayerResult {
    private final Player player;
    private final LadderResult result;

    PlayerResult(Player player, LadderResult result) {
        this.player = player;
        this.result = result;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getResult() {
        return result.getResult();
    }

    boolean matchPlayerName(String name) {
        return player.matchName(name);
    }
}
