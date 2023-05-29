package ladder.dto;

public class PlayerResult {
    private Player player;
    private Result result;

    public PlayerResult(Player player, Result result) {
        this.player = player;
        this.result = result;
    }

    public PlayerResult(String playerName, String resultValue) {
        this.player = new Player(playerName);
        this.result = new Result(resultValue);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Result getResult() {
        return this.result;
    }
}
