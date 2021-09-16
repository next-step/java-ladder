package step4.exception.ladder;

import step4.exception.CustomException;

public class LadderHeightException extends CustomException {

    private static final String LADDER_HEIGHT_ERROR_MESSAGE = "사다리 높이는 0보다 큰 자연수만 들어와야 한다.";

    public LadderHeightException(String message) {
        super(message);
    }

    public LadderHeightException() {
        this(LADDER_HEIGHT_ERROR_MESSAGE);
    }

}
