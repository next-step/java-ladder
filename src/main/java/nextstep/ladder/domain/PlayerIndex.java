package nextstep.ladder.domain;

public class PlayerIndex {

    private int playerIndex;

    private PlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public static PlayerIndex of(int playerIndex) {
        return new PlayerIndex(playerIndex);
    }

    public XAxis xAxis() {
        return XAxis.of(this.playerIndex);
    }
}
