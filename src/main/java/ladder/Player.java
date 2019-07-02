package ladder;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;
    private String playerName;

    public Player(String playerName) {
        this.playerName = validationCheck(playerName);
    }

    private String validationCheck(String playerName) {
        if (playerName.length() > MAX_NAME_LENGTH) {
            throw new IllegalStateException("Player 이름은 5글자 이하여야 합니다.");
        }
        return playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
