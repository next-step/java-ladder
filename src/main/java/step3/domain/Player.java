package step3.domain;

import java.util.Comparator;

public class Player implements Comparator<Player> {

    public static final int PLAYER_NAME_LENGTH_LIMIT = 5;

    private String playerName;

    private Player() {
        // blocks
    }

    public Player(String playerName) {
        if (playerName.length() > PLAYER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isPlayerName(String playerName) {
        return this.playerName.equals(playerName);
    }

    @Override
    public int compare(Player o1, Player o2) {
        return o2.getPlayerName().compareTo(o1.getPlayerName());
    }

}

