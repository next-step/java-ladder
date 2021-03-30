package ladder.exception;

public class CustomException extends RuntimeException{
    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }
}
