package domain;

import util.ErrorMessage;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private String player;

    public Player(String name) {
        this.checkPlayer(name);
        this.player = name;
    }

    private void checkPlayer(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NONE_PLAYER.getErrorMessage());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_EXCESS.getErrorMessage());
        }
    }

    @Override
    public String toString() {
        return this.player;
    }
}