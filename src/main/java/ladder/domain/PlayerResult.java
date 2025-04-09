package ladder.domain;

public class PlayerResult {
    private final Player player;
    private final String result;

    public PlayerResult(Player player, String result) {
        this.player = player;
        this.result = result;
    }

    public Player getPlayer() {
        return player;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "PlayerResult{" +
                "player=" + player +
                ", result='" + result + '\'' +
                '}';
    }
}
