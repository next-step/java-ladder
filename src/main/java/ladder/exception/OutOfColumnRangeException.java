package ladder.exception;

public class OutOfColumnRangeException extends IllegalArgumentException {

  public OutOfColumnRangeException() {
    super("사용 가능한 Column 의 범위에서 초과하였습니다");
  }
}
