package ladder.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomException extends RuntimeException {

    public static Logger logger = Logger.getGlobal();

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        logger.log(Level.SEVERE, String.valueOf(this.errorCode));
    }

    public ErrorCode errorCode() {
        return errorCode;
    }
}
