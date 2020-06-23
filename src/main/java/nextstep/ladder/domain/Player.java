package nextstep.ladder.domain;

public class Player {

    private PlayerName playerName;
    private PlayerIndex playerIndex;

    private Player(PlayerName playerName, PlayerIndex playerIndex) {
        this.playerName = playerName;
        this.playerIndex = playerIndex;
    }

    public static Player of(PlayerName playerName, PlayerIndex playerIndex) {
        return new Player(playerName, playerIndex);
    }

    public PlayerName convertPlayerNameWithLeftPad() {
        String playerNameWithPadding = playerName.convertUserNameWithLeftPad();
        return PlayerName.playerNameWithPadding(playerNameWithPadding);
    }

    public boolean isEqualWithPlayerName(PlayerName playerName) {
        return playerName.equals(this.playerName);
    }

    public Point point() {
        XAxis xAxis = this.playerIndex.xAxis();
        YAxis yAxis = YAxis.of(0);

        return Point.of(xAxis, yAxis);
    }

    @Override
    public String toString() {
        return this.playerName.toString();
    }
}
