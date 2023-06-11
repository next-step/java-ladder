package ladder.exception;

public class ResultIndecisiveException extends RuntimeException {

  public ResultIndecisiveException() {
    super("사다리게임 결과를 확정할 수 없습니다");
  }
}
