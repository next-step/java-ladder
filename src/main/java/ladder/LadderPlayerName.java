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

    @Override
    public String toString() {
        return String.format("%5s", playerName);
    }

    public String getName() {
        return playerName;
    }
}
