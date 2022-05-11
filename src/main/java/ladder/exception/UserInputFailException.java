package ladder.exception;

public class UserInputFailException extends RuntimeException {

  private static final String MESSAGE = "사용자 입력에 실패하였습니다.";

  public UserInputFailException() {
    super(MESSAGE);
  }
}
