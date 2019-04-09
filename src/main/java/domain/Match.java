package domain;

import util.ErrorMessage;

public class Match {
    private static final String ALL = "all";
    private Players players;
    private String player;

    public Match(Players players, String playerName) {
        this.checkName(players, playerName);
        this.players = players;
        this.player = playerName;
    }

    public void checkName(Players players, String playerName) {
        if (playerName != ALL && !this.isContainsPlayer(players, playerName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONTAINS_PLAYER.getErrorMessage());
        }
    }

    private boolean isContainsPlayer(Players players, String playerName) {
        return players.equals(playerName);
    }

    public int getPlayerIndex() {
        return this.players.getPlayerIndex(this.player);
    }
}
