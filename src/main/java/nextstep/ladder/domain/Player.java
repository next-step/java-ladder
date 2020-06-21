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
}
