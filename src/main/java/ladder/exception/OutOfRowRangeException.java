package ladder.exception;

public class OutOfRowRangeException extends IllegalArgumentException {

  public OutOfRowRangeException() {
    super("사용 가능한 Row 의 범위에서 초과하였습니다");
  }
}
