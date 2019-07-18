package ladder;

public class LadderPlayerName {
    public static final int MAX_PLAYER_NAME_LENGTH = 5;

    private final String playerName;

    private LadderPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static LadderPlayerName of(String playerName) {
        if (playerName.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalStateException("The player name should be smaller than " + MAX_PLAYER_NAME_LENGTH);
        }

        return new LadderPlayerName(playerName);
    }

    public boolean isEquals(String playerName) {
        return this.playerName.equals(playerName);
    }

    public String getName() {
        return playerName;
    }
}
