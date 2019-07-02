package com.ladder.exception;

public class NotMatchSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "플레이어와 보상의 개수는 일치해야합니다. (플레이어 개수: %d, 보상의 개수: %d)";

    public NotMatchSizeException(int countOfPlayers, int countOfRewards) {
        super(String.format(ERROR_MESSAGE, countOfPlayers, countOfRewards));
    }
}
