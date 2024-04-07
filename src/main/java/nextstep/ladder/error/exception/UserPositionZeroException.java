package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class UserPositionZeroException extends RuntimeException {

    public UserPositionZeroException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "현재 위치가 0인 경우 왼쪽으로 이동할 수 없습니다.",
            parameter));
    }

}
