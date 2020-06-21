package nextstep.ladder.domain;

public class Player {

    private PlayerName playerName;

    private Player(PlayerName playerName) {
        this.playerName = playerName;
    }

    public static Player of(PlayerName playerName) {
        return new Player(playerName);
    }

    public PlayerName convertPlayerNameWithLeftPad() {
        String playerNameWithPadding = playerName.convertUserNameWithLeftPad();
        return PlayerName.playerNameWithPadding(playerNameWithPadding);
    }
}
