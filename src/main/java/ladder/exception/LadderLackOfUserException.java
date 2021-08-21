package ladder.exception;

import ladder.domain.LadderGame;

public final class LadderLackOfUserException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리게임에 참여하는 사람수는 %d 이상이여야 합니다.";

    public LadderLackOfUserException() {
        super(String.format(MESSAGE, LadderGame.MIN_USER_COUNT));
    }
}
