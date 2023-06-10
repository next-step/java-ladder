package ladder.exception;

public class OutOfUsersCountException extends IllegalArgumentException {

  public OutOfUsersCountException() {
    super("입력한 유저의 수가 너무 많습니다");
  }
}
