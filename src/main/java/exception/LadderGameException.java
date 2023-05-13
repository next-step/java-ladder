package exception;

public class LadderGameException extends RuntimeException {

  private final ExceptionCode exceptionCode;

  public LadderGameException(ExceptionCode exceptionCode) {
    super(exceptionCode.getDefaultMessage());
    this.exceptionCode = exceptionCode;
  }

  public LadderGameException(ExceptionCode exceptionCode, String message) {
    super(message);
    this.exceptionCode = exceptionCode;
  }

  public ExceptionCode getExceptionCode() {
    return exceptionCode;
  }
}
