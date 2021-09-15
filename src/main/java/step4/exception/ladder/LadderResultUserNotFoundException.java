package step4.exception.ladder;

import step4.exception.CustomException;

public class LadderResultUserNotFoundException extends CustomException {

    private static final String USER_NOT_FOUND_ERROR_MESSAGE = "입력된 사람의 결과만 확인할 수 있다.";

    public LadderResultUserNotFoundException(String message) {
        super(message);
    }

    public LadderResultUserNotFoundException() {
        this(USER_NOT_FOUND_ERROR_MESSAGE);
    }

}
