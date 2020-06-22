package domain;

import java.util.Arrays;

public class Players {
    private static final int NAME_MAX_LENGTH = 5;
    private final String[] playerNames;

    private Players(String[] playerNames) {
        long validPlayers = Arrays.stream(playerNames)
                .filter(playerName -> playerName.length() <= NAME_MAX_LENGTH)
                .count();

        if (playerNames.length != validPlayers) {
            throw new IllegalArgumentException();
        }

        this.playerNames = playerNames;
    }

    public static Players of(String[] playerNames) {
        return new Players(playerNames);
    }

    public int countOfPlayers() {
        return playerNames.length;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }
}
