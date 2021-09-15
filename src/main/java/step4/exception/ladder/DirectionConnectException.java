package step4.exception.ladder;

import step4.exception.CustomException;

public class DirectionConnectException extends CustomException {

    private static final String LEFT_RIGHT_CONNECT_ERROR_MESSAGE = "왼쪽 오른쪽 둘 다 연결될 수 없다.";

    public DirectionConnectException(String message) {
        super(message);
    }

    public DirectionConnectException() {
        this(LEFT_RIGHT_CONNECT_ERROR_MESSAGE);
    }

}
