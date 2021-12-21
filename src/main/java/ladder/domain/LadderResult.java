package ladder.domain;



public class LadderResult {
    private final String player;
    private final String result;

    private LadderResult(String player, String result) {
        this.player = player;
        this.result = result;
    }

    public static LadderResult of(String player, String result) {
        return new LadderResult(player, result);
    }

    public String getPlayer() {
        return player;
    }

    public String getResult() {
        return result;
    }
}
