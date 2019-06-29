package com.ladder.exception;

import static com.ladder.model.Players.MIN_NUMBER_OF_PLAYERS;

public class PlayersLessMinimumException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "플레이어는 %d명 이상 이어야 합니다.";

    public PlayersLessMinimumException() {
        super(String.format(ERROR_MESSAGE, MIN_NUMBER_OF_PLAYERS));
    }
}
