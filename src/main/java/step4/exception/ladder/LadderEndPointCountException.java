package step4.exception.ladder;

import step4.exception.CustomException;

public class LadderEndPointCountException extends CustomException {

    private static final String LADDER_ENDPOINT_COUNT_ERROR_MESSAGE = "사람 수와 동일한 수의 결과가 입력되어야 한다.";

    public LadderEndPointCountException(String message) {
        super(message);
    }

    public LadderEndPointCountException() {
        this(LADDER_ENDPOINT_COUNT_ERROR_MESSAGE);
    }

}
