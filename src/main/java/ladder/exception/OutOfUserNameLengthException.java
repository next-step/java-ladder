package ladder.exception;

public class OutOfUserNameLengthException extends IllegalArgumentException {

  public OutOfUserNameLengthException() {
    super("유저 이름의 길이 제한을 초과하였습니다");
  }
}
