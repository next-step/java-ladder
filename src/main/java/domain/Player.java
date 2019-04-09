package domain;

import util.ErrorMessage;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private String player;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_EXCESS.getErrorMessage());
        }
        this.player = name;
    }

    @Override
    public String toString() {
        return this.player;
    }
}