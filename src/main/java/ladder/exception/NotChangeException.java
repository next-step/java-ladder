package ladder.exception;

import ladder.domain.Position;

public class NotChangeException extends RuntimeException {

    private static final String MESSAGE = "현재 위치가 최소 혹은 최대이라서 변경할 수 없습니다. 최솟값=%d, 최댓값=%d, 현재 위치=%d";

    public NotChangeException(int max, int position) {
        super(String.format(MESSAGE, Position.MIN_VALUE, max, position));
    }

    public NotChangeException(String message) {
        super(message);
    }
}
