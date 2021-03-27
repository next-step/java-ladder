package ladder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomException extends RuntimeException {

    public static Logger logger = LoggerFactory.getLogger("Logback logger");

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        logger.error(String.valueOf(this.errorCode));
    }

    public ErrorCode errorCode() {
        return errorCode;
    }
}
